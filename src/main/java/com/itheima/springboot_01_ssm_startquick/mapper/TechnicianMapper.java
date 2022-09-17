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

    /**
     * 根据传入的id查询相关的技师和技师相关的项目
     * @param id
     * @return
     */
    List<Technician> getTechnicianOne(int id);
}
