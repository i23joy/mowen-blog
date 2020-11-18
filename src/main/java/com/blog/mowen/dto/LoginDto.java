package com.blog.mowen.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class LoginDto {
    private String username;
    private String password;
}
