package us.digitalasylum.service;


import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.digitalasylum.repository.CategoryRepository;
import us.digitalasylum.repository.ChannelRepository;
import us.digitalasylum.repository.FeedRepository;
import us.digitalasylum.repository.ItemRepository;
import us.digitalasylum.repository.entities.Category;
import us.digitalasylum.repository.entities.Channel;
import us.digitalasylum.repository.entities.Feed;
import us.digitalasylum.repository.entities.Item;


import javax.print.attribute.standard.DateTimeAtCompleted;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

@Service
public class FeedService {

    private static final Logger logger = Logger.getLogger(FeedService.class);

    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void fetchItems(Long feedId){
        Feed feed = feedRepository.findOne(feedId);
        SyndFeed feedSrc = null;

        try{
            URL feedSource = new URL(feed.getUrl());
            SyndFeedInput input = new SyndFeedInput();
            feedSrc = input.build(new XmlReader(feedSource));

        }catch (IOException e) {
            logger.error("IO Problem while retrieving feed", e);
        }catch (FeedException e) {
            logger.error("Feed Problem while retrieving feed", e);
        }

        feed.setLastUpdated(new Date());
        feedRepository.save(feed);

        Channel channel = channelRepository.findByLink(feedSrc.getLink());
        if(channel == null)
        {
            channel = new Channel();
            channel.setTitle(feedSrc.getTitle());
            channel.setDescription(feedSrc.getDescription());

            if(feedSrc.getLink() != null){
                channel.setLink(feedSrc.getLink());
            }
            else if(feedSrc.getLinks().size() > 0){
                SyndLink link = (SyndLink) feedSrc.getLinks().get(0);
                channel.setLink(link.getHref());
            }

            if(feedSrc.getImage() != null)
            {
                channel.setImageTitle(feedSrc.getImage().getTitle());
                channel.setImageLink(feedSrc.getImage().getLink());
                channel.setImageUrl(feedSrc.getImage().getUrl());
            }
/*            else if(){

            }*/
            channel.setFeed(feed);

            channel = channelRepository.save(channel);
        }


        //create items  (entities)
        for(Object entry: feedSrc.getEntries())
        {
            SyndEntry syndEntry = (SyndEntry)entry;

            Item item = itemRepository.findByGuid(syndEntry.getUri());
            if(item == null)
            {
                item = new Item();
                item.setTitle(syndEntry.getTitle());
                item.setLink(syndEntry.getLink());
                item.setChannel(channel);

                SyndContent content = syndEntry.getDescription();

                if(content == null && syndEntry.getContents().size() > 0){
                    content = (SyndContent) syndEntry.getContents().get(0);
                }

                if(content != null){
                    String description = content.getValue();

                    int maxLength = 20000;
                    if(description.length() > maxLength){
                        description = description.substring(0, maxLength);
                    }
                    item.setDescription(description);
                }
                item.setPubDate(syndEntry.getPublishedDate());
                item.setGuid(syndEntry.getUri());
                item.setCreateDate(new Date());

                itemRepository.save(item);
            }
        }
    }

    @Transactional
    public void delete(Long feedId){
        Feed feed = feedRepository.findOne(feedId);

        feedRepository.delete(feed);
    }

    @Transactional
    public void update(Feed feed, Long categoryId){

        Category category = categoryRepository.findOne(categoryId);
        feed.setCategory(category);

        feedRepository.save(feed);
        return;
    }

    @Transactional
    public void fetchAllItems()
    {
        Iterable<Feed> feeds = feedRepository.findAll();

        for(Feed feed: feeds){
            fetchItems(feed.getId());
        }
    }

}
