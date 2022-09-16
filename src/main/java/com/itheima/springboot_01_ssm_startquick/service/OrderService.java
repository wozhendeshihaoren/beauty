package com.itheima.springboot_01_ssm_startquick.service;

import com.itheima.springboot_01_ssm_startquick.entity.Order;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import org.apache.ibatis.annotations.Param;

/**
 * @author woshihaoren
 */
public interface OrderService {
    /**
     * 插入一个预约订单的接口
     * @param token
     * @param order
     * @return
     */
    RespModel createOrder(String token, Order order);

    /**
     * 根据state获取订单
     * @param token 根据用户的token去查询openid
     * @param state 订单的状态
     * @return
     */
    RespModel getOrderAll(@Param("token") String token, @Param("state")String state);
}
