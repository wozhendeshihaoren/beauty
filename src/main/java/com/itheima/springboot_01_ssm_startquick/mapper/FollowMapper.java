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
}
