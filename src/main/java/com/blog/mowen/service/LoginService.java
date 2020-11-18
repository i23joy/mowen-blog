package com.blog.mowen.service;


import com.blog.mowen.dto.LoginDto;
import com.blog.mowen.vo.LoginUser;

public interface LoginService {
    LoginUser login(LoginDto loginDto);
}
