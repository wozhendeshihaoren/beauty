package com.itheima.springboot_01_ssm_startquick.mapper;

import com.itheima.springboot_01_ssm_startquick.entity.Order;
import org.apache.ibatis.annotations.Mapper;

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
}
