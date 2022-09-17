package com.itheima.springboot_01_ssm_startquick.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.springboot_01_ssm_startquick.entity.Project;
import com.itheima.springboot_01_ssm_startquick.mapper.ProjectMapper;
import com.itheima.springboot_01_ssm_startquick.model.ProjectModel;
import com.itheima.springboot_01_ssm_startquick.resp.RespCode;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author woshihaoren
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Override
    public RespModel getAllProject(int pageNum,int size) {
        try {
            int offset = (pageNum-1)*10;
            Page<Object> objects = PageHelper.offsetPage(offset, size);
            List<Project> allProject = projectMapper.getAllProject();

            long total = projectMapper.totalCount();
            ProjectModel<Project> projectModel = new ProjectModel<>(allProject,total);
            return new RespModel(RespCode.SUCCESS,projectModel);
        }catch (Exception e){
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }

    }

    @Override
    public RespModel getById(int id) {
        try {
              Project byId = projectMapper.getById(id);

            return new RespModel(RespCode.SUCCESS,byId);
        }catch (Exception e) {
            return new RespModel(RespCode.FAIL,null);
        }
    }

    /**
     * 根据project的protypeid查询
     * @param proTypeId
     * @return
     */
    @Override
    public RespModel getNavTitleProject(int proTypeId) {

        try {
        List<Project> navTitleProject = projectMapper.getNavTitleProject(proTypeId);
        return new RespModel(RespCode.SUCCESS,navTitleProject);

        }catch (Exception e){
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }

    }


}
