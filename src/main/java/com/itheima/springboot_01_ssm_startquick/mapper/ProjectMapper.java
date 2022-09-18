package com.itheima.springboot_01_ssm_startquick.mapper;

import com.itheima.springboot_01_ssm_startquick.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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


    /**
     * 收藏项目的查询
     * @param flag
     * @return
     */
    List<Project> getFavItem(String flag);

    /**
     * 根据项目的id更新flag的状态
     * @param id
     * @param flag
     */
    void updateProjectFlag(@Param("id")int id, @Param("flag")String flag);

    /**
     * 获取flag为true的数据
     * @return
     */
    long totalCountFlag();
}
