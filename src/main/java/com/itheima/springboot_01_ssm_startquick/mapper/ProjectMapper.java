package com.itheima.springboot_01_ssm_startquick.mapper;

import com.itheima.springboot_01_ssm_startquick.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author woshihaoren
 */
@Mapper
public interface ProjectMapper {
    /**
     * 得到所有的project数据
     * @return
     */
    public List<Project> getAllProject();

    /**
     * 返回project的总数量
     * @return
     */
    long totalCount();

    /**
     * 根据id返回一个project对象
     * @return
     * @param id
     */
    Project getById(int id);

    /**
     * 根据proTypeId获取项目
     * @param proTypeId
     * @return
     */
     List<Project> getNavTitleProject(int proTypeId);
}
