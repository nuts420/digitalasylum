package us.digitalasylum.tasks;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import us.digitalasylum.service.FeedService;

public class ItemFetchTask {
    private static final Logger logger = Logger.getLogger(ItemFetchTask.class);

    @Autowired
    private FeedService feedService;

    public void updateFeeds(){

        feedService.fetchAllItems();
        logger.debug("updateFeeds() called.");
        return;
    }

}
