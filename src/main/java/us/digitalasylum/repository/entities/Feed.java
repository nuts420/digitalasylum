package us.digitalasylum.repository.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import us.digitalasylum.repository.enums.FeedType;

@Entity
public class Feed {
    private Long id;
    private String url;

    private String name;
    private FeedType feedType;

    public Feed(){
    }

    public Feed(String name, String url, FeedType feedType){
        this.name = name;
        this.url = url;
        this.feedType = feedType;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FeedType getFeedType() {
        return feedType;
    }

    public void setFeedType(FeedType feedType) {
        this.feedType = feedType;
    }

}
