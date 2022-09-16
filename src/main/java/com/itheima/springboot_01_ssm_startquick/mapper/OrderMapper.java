package com.itheima.springboot_01_ssm_startquick.mapper;

import com.itheima.springboot_01_ssm_startquick.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author woshihaoren
 */
@Mapper
public interface OrderMapper {
    /**
     * 新增预约
     * @param order
     */
    void insert(Order order);

    /**
     * 根据订单的状态state去获取订单
     * @param openId
     * @param state
     * @return
     */
    List<Order> getOrderAll(String openId,String state);
}
