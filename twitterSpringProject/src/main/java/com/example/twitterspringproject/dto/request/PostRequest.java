package com.example.twitterspringproject.dto.request;

import com.example.twitterspringproject.dto.UserResponseDto;
import com.example.twitterspringproject.entities.TagEntity;

import java.util.List;

public class PostRequest {
    private String theme;
    private String text;
   // private UserEntity user;
    private List<String> tags;

    public PostRequest() {
    }

//    public UserResponseDto getUser() {
//        return user;
//    }
//
//    public void setUser(UserResponseDto user) {
//        this.user = user;
//    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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



}
