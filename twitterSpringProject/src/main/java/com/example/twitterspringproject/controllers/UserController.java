package com.example.twitterspringproject.controllers;

import com.example.twitterspringproject.dto.ResponseDto;
import com.example.twitterspringproject.dto.UserAuthDto;
import com.example.twitterspringproject.dto.UserRegisterDto;
import com.example.twitterspringproject.dto.UserResponseDto;
import com.example.twitterspringproject.exceptions.BaseException;
import com.example.twitterspringproject.mappers.UserMapper;
import com.example.twitterspringproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/twitter/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize(value = "hasRole('ROLE_USER')")
    @GetMapping(value = "/all")
    public ResponseDto<List<UserResponseDto>> getAllUsers(){

        ResponseDto<List<UserResponseDto>> responseDto = new ResponseDto<>();
        responseDto.setStatus("200");
        responseDto.setMessage("OK");
        responseDto.setData(UserMapper.mapListEntityToDto(this.userService.findAllUsers()));
        return responseDto;
    }

    @PostMapping(value = "/register")
    public ResponseDto<UserResponseDto> register(@RequestBody UserRegisterDto registerDto){
        ResponseDto responseDto = new ResponseDto<>();

        try{
            this.userService.register(UserMapper.toEntity(registerDto));
            responseDto.setMessage("Регистрация прошла успешно");
            responseDto.setStatus("OK");
        }catch (Exception e){
            responseDto.setStatus(e.getLocalizedMessage());
            responseDto.setMessage("FAIL");
        }
        return responseDto;
    }

    @PostMapping(value = "/login")
    public ResponseDto<UserResponseDto> login(@RequestBody UserAuthDto authDto){
        ResponseDto<UserResponseDto> responseDto = new ResponseDto<>();
        try {
            responseDto.setStatus("200");
            responseDto.setMessage("OK");
            responseDto.setData(UserMapper.toDto(this.userService.login(authDto.getLogin(), authDto.getPassword())));
        }
        catch (BaseException e){
            responseDto.setStatus("401");
            responseDto.setMessage(e.getMessage());
        }

        return new ResponseDto();
    }

    @GetMapping(value = "/info/{id}")
    public ResponseDto<UserResponseDto> getUserById(@PathVariable(name = "id") Long id){
        ResponseDto<UserResponseDto> responseDto = new ResponseDto<>();
        try {
            responseDto.setStatus("200");
            responseDto.setMessage("OK");
            responseDto.setData(UserMapper.toDto(this.userService.getById(id)));
        }
        catch (Exception e){
            responseDto.setStatus("401");
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/info_by_login")
    public ResponseDto<UserResponseDto> getUserByLogin(@RequestParam String login){
        ResponseDto<UserResponseDto> responseDto = new ResponseDto<>();
        try {
            responseDto.setStatus("200");
            responseDto.setMessage("OK");
            responseDto.setData(UserMapper.toDto(this.userService.getByLogin(login)));
        }
        catch (Exception e){
            responseDto.setStatus("401");
            responseDto.setMessage(e.getMessage());
        }

        return responseDto;


    }


}
