package com.example.twitterspringproject.mappers;

import com.example.twitterspringproject.dto.UserRegisterDto;
import com.example.twitterspringproject.dto.request.UserRequestDto;
import com.example.twitterspringproject.dto.UserResponseDto;
import com.example.twitterspringproject.entities.UserEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserEntity toEntity(UserRegisterDto source){
        UserEntity user = new UserEntity();
        user.setLogin(source.getLogin());
        user.setPassword(source.getPassword());
        user.setName(source.getFirstName());
        user.setSecondName(source.getSecondName());
        user.setDateBirth(LocalDate.parse(source.getDateBirth()));
        user.setUserType(source.getUserType());
        return user;
    }

    public static UserResponseDto toDto(UserEntity source){
        UserResponseDto user = new UserResponseDto();
        user.setId(source.getId());
        user.setLogin(source.getLogin());
        user.setName(source.getName());
        user.setSecondName(source.getSecondName());
        user.setDateOfBirth(source.getDateBirth());
        user.setUserType(source.getUserType());
        return user;
    }

    public static List<UserResponseDto> mapListEntityToDto(List<UserEntity> entityList){
        return entityList.stream().map(UserMapper::toDto).collect(Collectors.toList());
    }


}
