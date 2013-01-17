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
    public void initializeFeed(Feed feed){

        SyndFeed feedSrc = null;

        feedRepository.save(feed);

        try{
            URL feedSource = new URL(feed.getUrl());
            SyndFeedInput input = new SyndFeedInput();
            feedSrc = input.build(new XmlReader(feedSource));

        }catch (IOException e) {
            logger.error("IO Problem while retrieving feed", e);
        }catch (FeedException e) {
            logger.error("Feed Problem while retrieving feed", e);
        }

        //create channel
        Channel channel = new Channel(feedSrc.getTitle(), feedSrc.getLink(), feedSrc.getDescription(), feed, feedSrc.getImage().getUrl(), feedSrc.getImage().getTitle(), feedSrc.getImage().getLink());
        channel = channelRepository.save(channel);

        //create items  (entities)
        for(Object entry: feedSrc.getEntries())
        {
            SyndEntry syndEntry = (SyndEntry)entry;
            //Item item = new Item(((SyndEntry)entry).getTitle(), ((SyndEntry)entry).getLink(), ((SyndEntry)entry).getDescription().toString(), channel);
            Item item = new Item();
            item.setTitle(syndEntry.getTitle());
            item.setLink(syndEntry.getLink());
            item.setChannel(channel);
            item.setDescription(syndEntry.getDescription().getValue());

            itemRepository.save(item);
        }

    }

}
