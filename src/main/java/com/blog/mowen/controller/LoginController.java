package com.blog.mowen.controller;

import com.blog.mowen.common.CommonResult;
import com.blog.mowen.dto.LoginDto;
import com.blog.mowen.dto.UserRegisterDto;
import com.blog.mowen.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginDto loginDto) {
        return CommonResult.success(loginService.login(loginDto));
    }

    @ResponseBody
    @PostMapping("/register")
    public CommonResult register(@RequestBody UserRegisterDto userRegisterDto) {
        loginService.register(userRegisterDto);
        return CommonResult.success();
    }

    @GetMapping("/hello")
    @ResponseBody
    public CommonResult hello() {
        return CommonResult.success();
    }

/*    @Autowired
    private KafkaTemplate<Object, Object> template;

    @ApiOperation("send")
    @GetMapping("/send/{input}")
    public void sendFoo(@PathVariable String input) {
        this.template.send("ssss", input);
    }


    @KafkaListener(id = "webGroup", topics = "testTopic")
    public void listen(String input) {
        log.info("input value: {}" , input);
    }*/

}
