package com.example.twitterspringproject.exceptions;

public class UserNotFoundException extends BaseException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
