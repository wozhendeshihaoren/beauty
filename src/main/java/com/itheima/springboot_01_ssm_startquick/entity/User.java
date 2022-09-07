package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-08-03 09:38:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 微信用户唯一标识
     */
    private String openId;
    /**
     * 微信头像路径
     */
    private String imageURL;
    
    private String sessionKey;
    
    private String token;
    
    private String username;
    
    private String phone;
    
    private String password;

}

