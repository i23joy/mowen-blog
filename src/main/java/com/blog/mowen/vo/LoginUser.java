package com.blog.mowen.vo;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@ApiModel
@Builder
public class LoginUser {
    private String username;
    private String token;
    private String loginTime;
    private String avatar;
}
