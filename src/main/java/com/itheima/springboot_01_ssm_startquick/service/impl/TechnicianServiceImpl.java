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
}
