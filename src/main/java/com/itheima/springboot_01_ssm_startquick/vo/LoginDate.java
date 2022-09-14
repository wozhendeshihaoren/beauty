package com.itheima.springboot_01_ssm_startquick.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录页面数据实体
 * @author woshihaoren
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDate {
    String code;
    String phone;
    String password;

}
