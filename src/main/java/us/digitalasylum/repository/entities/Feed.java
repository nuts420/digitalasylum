package us.digitalasylum.repository.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import us.digitalasylum.repository.enums.FeedType;

import java.util.Date;

@Entity
public class Feed {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    private String url;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    private String name;
    @OneToOne(mappedBy = "feed", cascade = CascadeType.ALL)
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    //private FeedType feedType;

    public Feed(){
    }

    public Feed(String name, String url){
        this.name = name;
        this.url = url;
        this.lastUpdated = new Date();
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

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
}
