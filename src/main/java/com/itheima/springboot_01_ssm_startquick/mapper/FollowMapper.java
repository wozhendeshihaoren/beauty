package com.itheima.springboot_01_ssm_startquick.mapper;

import com.itheima.springboot_01_ssm_startquick.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author woshihaoren
 */
@Mapper
public interface FollowMapper {

    /**
     * 插入数据
     * @param follow
     * @return
     */
   void insertFollow(Follow follow);

    /**
     * 更新flag的状态
     * @param follow
     */
   void updateFollow(Follow follow);

    /**
     * 根据flag获取follow中的数据
     * @param flag
     * @return
     */
   List<Follow> getFollowFlagTrue(String flag);

    /**
     * 获取flag为true的follow数据
     * @return
     */
   Long totalFollowFlag();
}
