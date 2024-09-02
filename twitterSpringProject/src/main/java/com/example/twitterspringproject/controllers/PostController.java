package com.example.twitterspringproject.controllers;

import com.example.twitterspringproject.dto.ResponseDto;
import com.example.twitterspringproject.dto.request.PostResponse;
import com.example.twitterspringproject.entities.PostEntity;
import com.example.twitterspringproject.mappers.PostMapper;
import com.example.twitterspringproject.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/twitter/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/all")
    public ResponseDto getAllPosts(){
        ResponseDto<PostResponse> responseDto = new ResponseDto<>();
        responseDto.setMessage("OK");
        responseDto.setStatus("200");
        //responseDto.setData(PostMapper.(this.postService.findAllPosts());
        return new ResponseDto();
    }

    @PostMapping(value = "add")
    public ResponseDto addPost(){
        return new ResponseDto();
    }

    @GetMapping(value = "/my_posts/{userId}")
    public ResponseDto getMyPosts(@PathVariable(name = "userId") Long id){
        return new ResponseDto();
    }

    @PostMapping(value = "/posts_by_tag")
    public ResponseDto getPostsByTag(@RequestParam String tag){
        return new ResponseDto();
    }

    @PostMapping(value = "/posts_by_login")
    public ResponseDto getPostsByUserLogin(@RequestParam String login){
        return new ResponseDto();
    }

    @PostMapping(value = "/posts_by_user_type")
    public ResponseDto getPostsByUserType(@RequestParam String userType){
        return new ResponseDto();
    }


}
