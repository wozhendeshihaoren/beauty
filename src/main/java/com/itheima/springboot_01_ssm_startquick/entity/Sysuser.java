package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Sysuser)实体类
 *
 * @author makejava
 * @since 2022-08-03 09:35:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sysuser implements Serializable {
    /**
     * 系统用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 关联图片id
     */
    private Long imageId;

}

