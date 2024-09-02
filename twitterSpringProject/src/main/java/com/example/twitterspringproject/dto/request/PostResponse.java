package com.example.twitterspringproject.dto.request;

import com.example.twitterspringproject.dto.UserResponseDto;
import com.example.twitterspringproject.entities.TagEntity;
import com.example.twitterspringproject.entities.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PostResponse {
    private Long id;
    private String theme;
    private String text;
    private LocalDate publicationDate;
    private UserResponseDto user;
    private List<TagEntity> tags;

    public PostResponse() {
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

    public UserResponseDto getUser() {
        return user;
    }

    public void setUser(UserResponseDto user) {
        this.user = user;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }
}
