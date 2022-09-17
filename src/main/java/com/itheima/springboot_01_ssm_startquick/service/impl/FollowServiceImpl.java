package com.itheima.springboot_01_ssm_startquick.service.impl;

import com.itheima.springboot_01_ssm_startquick.entity.Follow;
import com.itheima.springboot_01_ssm_startquick.mapper.FollowMapper;
import com.itheima.springboot_01_ssm_startquick.resp.RespCode;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author woshihaoren
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Override
    public RespModel insertFollow(Follow follow) {

      try {

           followMapper.insertFollow(follow);
          return  new RespModel(RespCode.SUCCESS_4,null);
      }catch (Exception e) {
          e.printStackTrace();
          return  new RespModel(RespCode.FAIL,null);
      }

    }
}
