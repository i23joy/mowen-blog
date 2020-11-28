package com.blog.mowen.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
    private String message;
    private Integer code;
    private Object data;
    private Boolean success;

    private CommonResult() {}

    private CommonResult(String message, Integer code, Object data, Boolean success) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.success = success;
    }

    public CommonResult(Object data) {
        this.message = "success";
        this.code = 200;
        this.data = data;
        this.success = true;
    }

    public static CommonResult success(Object data) {
        return new CommonResult(data);
    }

    public static CommonResult failed(String errMsg, Integer code) {
        return new CommonResult(errMsg, code, null, false);
    }

    public static CommonResult success() {
        return new CommonResult(null);
    }
}
