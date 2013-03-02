package us.digitalasylum.repository.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    private String name;
    private Integer ordinal;
    @OneToMany(mappedBy = "category")
    private List<Feed> feed;

    public Category(){

    }
    public Category(String name, Integer order){
        this.name = name;
        this.ordinal = order;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public List<Feed> getFeed() {
        return feed;
    }

    public void setFeed(List<Feed> feed) {
        this.feed = feed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
