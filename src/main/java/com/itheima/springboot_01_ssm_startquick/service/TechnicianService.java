package com.itheima.springboot_01_ssm_startquick.service;

import com.itheima.springboot_01_ssm_startquick.resp.RespModel;

/**
 * 技师服务层
 * @author woshihaoren
 */
public interface TechnicianService {
    /**
     * 得到所有的技师信息
     * @return
     */
    RespModel getTechnicianAll();
}
