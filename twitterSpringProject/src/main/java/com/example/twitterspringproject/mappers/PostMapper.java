package com.example.twitterspringproject.mappers;

import com.example.twitterspringproject.dto.UserRegisterDto;
import com.example.twitterspringproject.dto.request.PostRequest;
import com.example.twitterspringproject.dto.request.PostResponse;
import com.example.twitterspringproject.entities.PostEntity;
import com.example.twitterspringproject.entities.UserEntity;

import java.time.LocalDate;

public class PostMapper {
    public static PostEntity toEntity(PostRequest source){
        PostEntity postRequest = new PostEntity();
        postRequest.setTheme(source.getTheme());
        postRequest.setText(source.getText());
        postRequest.setTags(source.getTags());
        //postRequest.setUser(source.getUser());
        return postRequest;
    }

    public static PostResponse toDto(PostEntity source){
        PostResponse postResponse = new PostResponse();
        postResponse.setId(source.getId());
        postResponse.setTheme(source.getTheme());
        postResponse.setText(source.getText());
        postResponse.setPublicationDate(source.getPublicationDate());
        return postResponse;
    }
}
