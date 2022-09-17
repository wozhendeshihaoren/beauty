package com.itheima.springboot_01_ssm_startquick.controller;

import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 技师控制层
 * @author woshihaoren
 */
@RestController
@RequestMapping("/technician")
public class TechnicianController {

    @Autowired
   private TechnicianService technicianService;

    @RequestMapping("/getAll")
    public RespModel getTechnicianAll(){
        return technicianService.getTechnicianAll();
    }

    @RequestMapping("/byId")
    public RespModel getTechnicianOne(int id){

        return technicianService.getTechnicianOne(id);
    }
}
