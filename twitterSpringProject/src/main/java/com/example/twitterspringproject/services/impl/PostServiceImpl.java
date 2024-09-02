package com.example.twitterspringproject.services.impl;

import com.example.twitterspringproject.dto.request.PostRequest;
import com.example.twitterspringproject.entities.PostEntity;
import com.example.twitterspringproject.entities.UserEntity;
import com.example.twitterspringproject.exceptions.UserNotFoundException;
import com.example.twitterspringproject.repositories.PostRepository;
import com.example.twitterspringproject.services.PostService;
import com.example.twitterspringproject.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostEntity> findAllPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public PostEntity addPost(PostEntity post){
        return this.postRepository.save(post);
    }


}
