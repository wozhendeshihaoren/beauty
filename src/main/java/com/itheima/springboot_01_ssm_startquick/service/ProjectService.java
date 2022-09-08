package com.itheima.springboot_01_ssm_startquick.service;

import com.itheima.springboot_01_ssm_startquick.entity.Project;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author woshihaoren
 */
public interface ProjectService {

    /**
     * 操作ProjectMapper,与mapper交互
     * @return
     */
    RespModel getAllProject(int pageNum,int size) ;

    /**
     * 返回一个project
     * @param id
     * @return
     */
    RespModel getById(int id);

}
