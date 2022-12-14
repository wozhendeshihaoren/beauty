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

    /**
     * 插入一条关注的信息
     * @param follow
     * @return
     */
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


    /**
     * 更新一条关注信息
     * @param follow
     * @return
     */
    @Override
    public RespModel updateFollow(Follow follow) {

        try {

            followMapper.updateFollow(follow);
            return new RespModel(RespCode.SUCCESS_5,null);
        }catch (Exception e){
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }

    }

    /**
     * 获取所有关注的信息
     * @param flag
     * @return
     */
    @Override
    public RespModel getFollowFlagTrue(String flag) {
        try {


        List<Follow> followFlagTrue = followMapper.getFollowFlagTrue(flag);
        return new RespModel(RespCode.SUCCESS,followFlagTrue);
        }catch (Exception e) {
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }
    }

    /**
     * 获取所有关注的数目
     * @return
     */
    @Override
    public RespModel totalFollowFlag() {

        try {
            Long totalFlag = followMapper.totalFollowFlag();

            return  new RespModel(RespCode.SUCCESS,totalFlag);

        }catch (Exception e) {

            return  new RespModel(RespCode.FAIL,null);
        }
    }
}
