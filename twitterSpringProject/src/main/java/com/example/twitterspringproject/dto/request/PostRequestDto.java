package com.example.twitterspringproject.dto.request;

import com.example.twitterspringproject.dto.UserResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public class PostRequestDto {
    private String theme;
    private String text;
    private LocalDateTime publicationDate;
    private UserResponseDto user;
    private List<String> tags;


}
