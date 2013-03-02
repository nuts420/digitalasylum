package us.digitalasylum.repository.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private List<Channel> channels;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Feed(){
    }

    public Feed(String name, String url, Category category){
        this.name = name;
        this.url = url;
        this.category = category;
        this.lastUpdated = new Date();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Channel> getChannel() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
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
