package com.itheima.springboot_01_ssm_startquick.resp;

import lombok.Data;

/**
 * @author qin
 * @create 2022--09--07--16:43
 */

public enum RespCode {
    SUCCESS("0","请求成功"),
    SUCCESS_1("1","注册成功"),
    SUCCESS_2("2","登录成功"),
    SUCCESS_3("3","预约成功"),
    SUCCESS_4("4","插入成功"),
    FAIL("9999","网络异常"),
    FAIL_1("9991","用户名为空"),
    FAIL_2("9992","密码为空"),
    FAIL_3("9993","号码格式错误"),
    FAIL_4("9994","号码为空"),
    ERROR_5("9995","已经有账号了"),
    ERROR_6("9996","账号或密码错误");




    private String code;
    private String message;

    RespCode() {
    }

    RespCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
