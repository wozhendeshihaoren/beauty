package com.itheima.springboot_01_ssm_startquick.service;

import com.itheima.springboot_01_ssm_startquick.entity.Order;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;

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
}
