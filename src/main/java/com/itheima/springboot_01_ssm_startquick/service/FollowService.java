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
}
