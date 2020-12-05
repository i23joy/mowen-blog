package com.blog.mowen.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String id;
    private String username;
    private String password;
    private String email;
    private String avatar;
}
