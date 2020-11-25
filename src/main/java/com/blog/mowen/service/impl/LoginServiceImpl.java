package com.blog.mowen.service.impl;

import com.blog.mowen.dto.LoginDto;
import com.blog.mowen.dto.UserRegisterDto;
import com.blog.mowen.model.entity.UserEntity;
import com.blog.mowen.model.repository.UserRepo;
import com.blog.mowen.service.LoginService;
import com.blog.mowen.vo.LoginUser;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public LoginUser login(LoginDto loginDto) {
        return LoginUser.builder().avatar("avatar").username("xuewen.wu").loginTime("2020-11-18").build();
    }

    @Override
    public void register(UserRegisterDto registerDto) {
        UserEntity entity = initEntity(registerDto);
        userRepo.saveAndFlush(entity);
        log.debug("user register success! data: [{}]", entity);
    }

    private UserEntity initEntity(UserRegisterDto registerDto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(registerDto.getUsername());
        entity.setAvatar(registerDto.getAvatarUrl());
        entity.setPassword(registerDto.getPassword());
        entity.setEmail(registerDto.getEmail());
        return entity;
    }

}
