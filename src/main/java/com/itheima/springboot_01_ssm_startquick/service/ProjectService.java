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

    /**
     * 根据project的protypeid查询
     * @param proTypeId
     * @return
     */
    RespModel getNavTitleProject(int proTypeId);

    /**
     * 收藏项目的查询
     * @param flag
     * @return
     */
    RespModel getFavItem(String flag);

    /**
     * 通过id更新flag的状态
     * @param id
     * @param flag
     * @return
     */
    RespModel updateProjectFlag(int id ,String flag) ;

    /**
     * 获取flag为true的数据
     * @return
     */
    RespModel totalCountFlag();
}
