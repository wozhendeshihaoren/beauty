package com.itheima.springboot_01_ssm_startquick.mapper;

import com.itheima.springboot_01_ssm_startquick.entity.Technician;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author woshihaoren
 */
@Mapper
public interface TechnicianMapper {

    /**
     * 得到所有的技师信息
     * @return
     */
    List<Technician> getTechnicianAll();
}
