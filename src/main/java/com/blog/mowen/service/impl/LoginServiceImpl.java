package com.blog.mowen.service.impl;

import com.blog.mowen.dto.LoginDto;
import com.blog.mowen.dto.UserRegisterDto;
import com.blog.mowen.exception.CommonException;
import com.blog.mowen.model.entity.UserEntity;
import com.blog.mowen.model.repository.UserRepo;
import com.blog.mowen.service.LoginService;
import com.blog.mowen.util.BlobUtils;
import com.blog.mowen.util.DateUtils;
import com.blog.mowen.vo.LoginUser;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

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
        throw new CommonException(HttpStatus.FORBIDDEN, "username and password do not match", 403);
    }

    @Override
    public void register(UserRegisterDto registerDto) {
        UserEntity userEntityByUsername = userRepo.findByUsername(registerDto.getUsername());
        UserEntity entity = initEntity(registerDto);
        if (userEntityByUsername != null) {
            throw new CommonException(HttpStatus.BAD_REQUEST, "The username already exists", 400);
        }
        try {
            UserEntity userEntity = userRepo.saveAndFlush(entity);
            log.info("user register success! data: [{}]", userEntity);
        } catch (Exception e) {
            log.error("register happens error [{}]", e.getMessage());
        }
    }

    @Override
    public void modifyAvatar(UserRegisterDto registerDto) {
        UserEntity userEntity = userRepo.findByUsername(registerDto.getUsername().toLowerCase());
        userEntity.setAvatar(Base64Utils.decodeFromString(registerDto.getAvatar()));
        userRepo.saveAndFlush(userEntity);
        log.info("user [{}] update avatar success", registerDto.getUsername());
    }

    private UserEntity initEntity(UserRegisterDto registerDto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(registerDto.getUsername().toLowerCase());
        entity.setPassword(registerDto.getPassword());
        entity.setEmail(registerDto.getEmail());
        return entity;
    }

    private LoginUser initLoginUser(UserEntity entity) {
        return LoginUser.builder().loginTime(DateUtils.nowLocalDateTime())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .id(entity.getUid())
                .build();
    }

}
