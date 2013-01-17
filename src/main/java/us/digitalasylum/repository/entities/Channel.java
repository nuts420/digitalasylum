package us.digitalasylum.repository.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Channel {

    private long id;
    private String title;
    private String link;
    private String description;
    private Feed feed;
    private String imageUrl;
    private String imageTitle;
    private String imageLink;

    public Channel(){

    }

    public Channel(String title, String link, String description, Feed feed, String imageUrl, String imageTitle, String imageLink){
        this.title = title;
        this.link = link;
        this.description = description;
        this.feed = feed;
        this.imageUrl = imageUrl;
        this.imageTitle = imageTitle;
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Column(length=500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
