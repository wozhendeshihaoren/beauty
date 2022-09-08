package com.itheima.springboot_01_ssm_startquick.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一结果处理
 * @author qin
 * @create 2022--09--07--9:48
 */
@Data
public class RespModel {
    private String code;
    private String message;
    private Object data;

    public RespModel() {
    }

    public RespModel(RespCode respCode, Object data) {
        this.code = respCode.getCode();
        this.message = respCode.getMessage();
        this.data = data;
    }
}
