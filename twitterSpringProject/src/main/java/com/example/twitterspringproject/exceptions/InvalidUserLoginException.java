package com.example.twitterspringproject.exceptions;

public class InvalidUserLoginException extends BaseException{
    public InvalidUserLoginException(String message) {
        super(message);
    }
}
