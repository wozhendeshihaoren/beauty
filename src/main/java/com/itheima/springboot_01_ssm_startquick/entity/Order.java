package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author woshihaoren
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    /**
     * 订单id
     */
    private Long id;
    /**
     * 关联user表的openId
     */
    private String openId;
    /**
     * 项目名称
     */
    private String proName;
    /**
     * 预约时间
     */
    private String makeDate;
    /**
     * 预约客户姓名
     */
    private String userName;
    /**
     * 预约状态
     */
    private String orderState;
    /**
     * 下单时间
     */
    private String placeDate;
    /**
     * 手机号
     */
    private String userTell;
    /**
     * 留言
     */
    private String information;
    /**
     * 关联商家id
     */
    private Long busId;
    /**
     * 关联产品id
     */
    private Long proId;
    
    private Long tecId;

    private Project project;

    private Business business;


}

