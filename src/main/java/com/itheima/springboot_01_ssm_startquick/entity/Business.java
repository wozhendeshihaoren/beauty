package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Business)实体类
 *
 * @author woshihaoren
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business implements Serializable {

    private Long id;
    /**
     * 商家名称
     */
    private String busName;
    /**
     * 商家地址
     */
    private String busAddress;
    /**
     * 商家介绍
     */
    private String busExplain;
    /**
     * 商家电话
     */
    private String busSell;
    /**
     * 服务时间
     */
    private String serverTime;
    /**
     * 项目
     */
    private Project project;

}

