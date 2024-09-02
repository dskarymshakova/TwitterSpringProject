package com.example.twitterspringproject.services;

import com.example.twitterspringproject.entities.UserEntity;
import com.example.twitterspringproject.exceptions.InvalidAuthException;
import com.example.twitterspringproject.exceptions.InvalidUserLoginException;
import com.example.twitterspringproject.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<UserEntity> findAllUsers();
    void register(UserEntity entity);
    UserEntity login(String login, String password) throws InvalidUserLoginException, InvalidAuthException;
    UserEntity getById(Long id) throws UserNotFoundException;
    UserEntity getByLogin(String login);

}
