package us.digitalasylum.service;


import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.digitalasylum.repository.ChannelRepository;
import us.digitalasylum.repository.FeedRepository;
import us.digitalasylum.repository.ItemRepository;
import us.digitalasylum.repository.entities.Channel;
import us.digitalasylum.repository.entities.Feed;
import us.digitalasylum.repository.entities.Item;


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

    @Transactional
    public void updateFeed(Long feedId){
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
            channel.setLink(feedSrc.getLink());
            if(feedSrc.getImage() != null)
            {
                channel.setImageTitle(feedSrc.getImage().getTitle());
                channel.setImageLink(feedSrc.getImage().getLink());
                channel.setImageUrl(feedSrc.getImage().getUrl());
            }
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
                item.setDescription(syndEntry.getDescription().getValue());
                item.setPubDate(syndEntry.getPublishedDate());
                item.setGuid(syndEntry.getUri());

                itemRepository.save(item);
            }
        }
    }

    @Transactional
    public void delete(Long feedId){
        Feed feed = feedRepository.findOne(feedId);



        feedRepository.delete(feed);
    }

}
