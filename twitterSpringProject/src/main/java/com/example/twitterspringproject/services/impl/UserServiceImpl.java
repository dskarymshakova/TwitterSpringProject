package com.example.twitterspringproject.services.impl;

import com.example.twitterspringproject.entities.UserEntity;
import com.example.twitterspringproject.exceptions.InvalidAuthException;
import com.example.twitterspringproject.exceptions.InvalidUserLoginException;
import com.example.twitterspringproject.exceptions.UserNotFoundException;
import com.example.twitterspringproject.repositories.UserRepository;
import com.example.twitterspringproject.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        List<UserEntity> users = this.userRepository.receiveAllUsers();
        if (users.isEmpty()) {
            return new ArrayList<>();
        }
        return users;
    }

    @Override
    public void register(UserEntity entity) {
        this.userRepository.save(entity);
    }

    @Override
    public UserEntity login(String login, String password) throws InvalidUserLoginException, InvalidAuthException {
        UserEntity entity = this.userRepository.findByLogin(login);
        if(Objects.isNull(entity)){
            throw new InvalidUserLoginException("Пользователя с таким логином не существует");
        }
        if(!entity.getPassword().equals(password)){
            throw new InvalidAuthException("Логин или пароль неверный");
        }
        return entity;
    }

    @Override
    public UserEntity getById(Long id) throws UserNotFoundException {
        return this.userRepository.findById(id).orElseThrow(()->new UserNotFoundException("Нет такого пользователя"));
    }

    @Override
    public UserEntity getByLogin(String login) {
        return this.userRepository.findByLogin(login);
    }
}
