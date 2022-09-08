package com.itheima.springboot_01_ssm_startquick.controller;

import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.ProjectService;
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
    public RespModel getAllProject( int pageNum,  int size){
        return projectService.getAllProject(pageNum,size);
    }
}
