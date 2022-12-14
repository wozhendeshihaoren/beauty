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

    /**
     * 根据传入的id查询相关的技师和技师相关的项目
     * @param id
     * @return
     */
    RespModel getTechnicianOne(int id);
}
