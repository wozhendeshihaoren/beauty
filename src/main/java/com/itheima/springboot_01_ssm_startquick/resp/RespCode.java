package com.itheima.springboot_01_ssm_startquick.resp;

import lombok.Data;

/**
 * @author qin
 * @create 2022--09--07--16:43
 */

public enum RespCode {
    SUCCESS("0","请求成功"),
    FAIL("9999","网络异常");




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
