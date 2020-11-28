package com.blog.mowen.exception.handler;

import com.blog.mowen.common.CommonResult;
import com.blog.mowen.exception.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<CommonResult> handleCommonException(CommonException e) {
        return ResponseEntity.status(e.getRespStatus())
                .body(CommonResult.failed(e.getErrMsg(), e.getRespStatus().value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResult> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(CommonResult.failed(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
