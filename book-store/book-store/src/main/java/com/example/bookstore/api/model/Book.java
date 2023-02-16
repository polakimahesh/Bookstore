package com.example.bookstore.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;

    @JsonManagedReference
    @NotNull
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    private String yearOfPublication;

    @Lob
    private String description;

    @JsonManagedReference
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Topic.class)
    @JoinTable(name = "book_topic",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Topic> topics = new HashSet<>();

    @NotNull
    private BigDecimal price;

    //Constructors
    @Autowired
    public Book(Long id, String title, Set<Author> author, String yearOfPublication,
                String description, Set<Topic> topics, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.authors = author;
        this.yearOfPublication = yearOfPublication;
        this.description = description;
        this.topics = topics;
        this.price = price;
    }

    public Book() {
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
