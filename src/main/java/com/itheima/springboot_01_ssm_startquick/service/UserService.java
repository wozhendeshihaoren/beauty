package com.itheima.springboot_01_ssm_startquick.service;

import com.itheima.springboot_01_ssm_startquick.entity.User;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.vo.LoginDate;

/**
 * @author woshihaoren
 */
public interface UserService {

    /**
     * 注册功能的业务端接口
     * @param user
     * @return
     */
    RespModel register(User user);


    /**
     * 登录页面的业务接口
     * @param loginDate
     * @return
     */
    RespModel login(LoginDate loginDate);
}
