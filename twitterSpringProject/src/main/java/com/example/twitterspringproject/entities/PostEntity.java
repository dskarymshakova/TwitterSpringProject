package com.example.twitterspringproject.entities;

import com.example.twitterspringproject.converter.jpa.TagsConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "theme")
    private String theme;
    @Column(name = "text")
    private String text;
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private UserEntity user;

    @Column(name="tags")
    //@Convert(converter = TagsConverter.class)
    @Type(type = "com.example.twitterspringproject.converter.hibernate.TagsType")
    private List<String> tags;

    @ManyToMany(mappedBy = "postEntityList")
    private List<TagEntity> tagEntityList;

//    @ManyToMany
//    @JoinTable(name = "m2m_posts_tags")

    public PostEntity() {
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<TagEntity> getTagEntityList() {
        return tagEntityList;
    }

    public void setTagEntityList(List<TagEntity> tagEntityList) {
        this.tagEntityList = tagEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
