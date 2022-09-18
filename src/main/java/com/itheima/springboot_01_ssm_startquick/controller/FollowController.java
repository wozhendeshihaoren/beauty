package com.itheima.springboot_01_ssm_startquick.controller;

import com.itheima.springboot_01_ssm_startquick.entity.Follow;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author woshihaoren
 */
@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @RequestMapping("/insertId")
    public RespModel insertFollow(Follow follow){

        return followService.insertFollow(follow);
    }

    @RequestMapping("/updateId")
    public  RespModel updateFollow(Follow follow){
        return  followService.updateFollow(follow);
    }

    @RequestMapping("/getFollowFlagTrue")
    public  RespModel getFollowFlagTrue(String flag){
        return followService.getFollowFlagTrue(flag);
    }


    @RequestMapping("/totalFlag")
    public  RespModel totalFollowFlag(){
        return followService.totalFollowFlag();
    }
}
