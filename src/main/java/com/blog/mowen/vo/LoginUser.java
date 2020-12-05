package com.blog.mowen.vo;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;

@Data
@ApiModel
@Builder
public class LoginUser {
    private String id;
    private String username;
    private String token;
    private String loginTime;
    private String avatar;
    private String email;
}
