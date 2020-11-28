package com.blog.mowen.service.impl;

import com.blog.mowen.dto.LoginDto;
import com.blog.mowen.dto.UserRegisterDto;
import com.blog.mowen.exception.CommonException;
import com.blog.mowen.model.entity.UserEntity;
import com.blog.mowen.model.repository.UserRepo;
import com.blog.mowen.service.LoginService;
import com.blog.mowen.util.DateUtils;
import com.blog.mowen.vo.LoginUser;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public LoginUser login(LoginDto loginDto) {
        UserEntity entity = userRepo.findByUsername(loginDto.getUsername());
        if (entity != null && loginDto.getPassword().equals(entity.getPassword())) {
            return initLoginUser(entity);
        }
        throw new CommonException(HttpStatus.UNAUTHORIZED, "username and password do not match", 403);
    }

    @Override
    public void register(UserRegisterDto registerDto) {
        UserEntity entity = initEntity(registerDto);
        userRepo.saveAndFlush(entity);
        log.info("user register success! data: [{}]", entity);
    }

    private UserEntity initEntity(UserRegisterDto registerDto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(registerDto.getUsername());
        entity.setAvatar(registerDto.getAvatarUrl());
        entity.setPassword(registerDto.getPassword());
        entity.setEmail(registerDto.getEmail());
        return entity;
    }

    private LoginUser initLoginUser(UserEntity entity) {
        return LoginUser.builder().loginTime(DateUtils.nowLocalDateTime())
                .username(entity.getUsername())
                .avatar(entity.getAvatar())
                .email(entity.getEmail())
                .build();
    }

}
