package com.blog.mowen.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonException extends RuntimeException{
    private HttpStatus respStatus;
    private String errMsg;
    private Integer code;

    public CommonException(HttpStatus respStatus, String errMsg, Integer code) {
        this.code = code;
        this.errMsg = errMsg;
        this.respStatus = respStatus;
    }
}
