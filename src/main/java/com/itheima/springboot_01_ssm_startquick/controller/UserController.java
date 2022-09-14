package com.itheima.springboot_01_ssm_startquick.controller;

import com.itheima.springboot_01_ssm_startquick.entity.User;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.UserService;
import com.itheima.springboot_01_ssm_startquick.vo.LoginDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author woshihaoren
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 注册页面请求处理
     * @param user
     * @return
     */
   @PostMapping("/register")
    public RespModel register(User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public RespModel login(LoginDate loginDate) {
        return userService.login(loginDate);
    }

}
