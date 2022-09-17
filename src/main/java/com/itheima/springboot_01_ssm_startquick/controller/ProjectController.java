package com.itheima.springboot_01_ssm_startquick.controller;

import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.ProjectService;
import com.itheima.springboot_01_ssm_startquick.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qin
 * @create 2022--09--07--16:17
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @RequestMapping("/all")
    public RespModel getAllProject( int pageNum,int size){
        return projectService.getAllProject(pageNum,size);
    }

    /**
     * 通过项目id获取用户数据
     * @param id
     * @return
     */
    @RequestMapping("/byId")
    public RespModel byId(int id){
        return projectService.getById(id);
    }

    @RequestMapping("/navTitleType")
    public  RespModel getNavTitleProject(int proTypeId){

        return projectService.getNavTitleProject(proTypeId);
    }
}
