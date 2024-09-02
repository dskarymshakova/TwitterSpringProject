package com.example.twitterspringproject.services;

import com.example.twitterspringproject.dto.request.PostRequest;
import com.example.twitterspringproject.entities.PostEntity;
import com.example.twitterspringproject.exceptions.UserNotFoundException;

import java.util.List;

public interface PostService {
    List<PostEntity> findAllPosts();

    PostEntity addPost(PostEntity post) ;
}
