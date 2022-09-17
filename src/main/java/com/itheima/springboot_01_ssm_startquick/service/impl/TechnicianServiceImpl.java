package com.itheima.springboot_01_ssm_startquick.service.impl;

import com.itheima.springboot_01_ssm_startquick.entity.Technician;
import com.itheima.springboot_01_ssm_startquick.mapper.TechnicianMapper;
import com.itheima.springboot_01_ssm_startquick.resp.RespCode;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author woshihaoren
 */
@Service
public class TechnicianServiceImpl implements TechnicianService {


    @Autowired
    private TechnicianMapper technicianMapper;

    @Override
    public RespModel getTechnicianAll() {
        try {
            List<Technician> technicianAll = technicianMapper.getTechnicianAll();
            return new RespModel(RespCode.SUCCESS,technicianAll);
        }catch (Exception e){
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }
    }

    @Override
    public RespModel getTechnicianOne(int id) {

         try {
             //根据id请求技师的信息
             List<Technician> technicianOne = technicianMapper.getTechnicianOne(id);
             Technician technician = technicianOne.get(0);

             //返回技师信息
             return new RespModel(RespCode.SUCCESS,technician);
         }catch (Exception e) {
             e.printStackTrace();
             return  new RespModel(RespCode.FAIL,null);
         }
    }
}
