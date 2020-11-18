package com.blog.mowen.service.impl;

import com.blog.mowen.dto.LoginDto;
import com.blog.mowen.service.LoginService;
import com.blog.mowen.vo.LoginUser;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public LoginUser login(LoginDto loginDto) {
        return LoginUser.builder().avatar("avatar").username("xuewen.wu").loginTime("2020-11-18").build();
    }
}
