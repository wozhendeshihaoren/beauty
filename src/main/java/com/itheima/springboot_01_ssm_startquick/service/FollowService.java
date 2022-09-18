package com.itheima.springboot_01_ssm_startquick.service;

import com.itheima.springboot_01_ssm_startquick.entity.Follow;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;

/**
 * @author woshihaoren
 */
public interface FollowService {

    /**
     * follow插入数据
     * @param follow
     * @return
     */
    RespModel insertFollow(Follow follow);

    /**
     * 更新flag的状态
     * @param follow
     * @return
     */
    RespModel updateFollow(Follow follow);

    /**
     * 得到follow中flag为true或为false的数据
     * @param flag
     * @return
     */
    RespModel getFollowFlagTrue(String flag);

    /**
     * 获取flag为true的数据
     * @return
     */
    RespModel totalFollowFlag();
}
