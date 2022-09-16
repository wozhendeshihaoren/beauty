package com.itheima.springboot_01_ssm_startquick.controller;


import com.itheima.springboot_01_ssm_startquick.entity.Order;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *预约订单的controller层
 * @author woshihaoren
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public RespModel createOrder(String token,Order order){
        return  orderService.createOrder(token,order);
    }

    @RequestMapping("/getAll")
    public RespModel getOrderAll(String token,String state){
        return orderService.getOrderAll(token,state);
    }

}
