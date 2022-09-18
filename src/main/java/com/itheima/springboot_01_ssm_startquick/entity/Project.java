package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Project)实体类
 *
 * @author makejava
 * @since 2022-08-03 09:32:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    /**
     * 项目id
     */
    private Long id;
    /**
     * 项目介绍
     */
    private String proExplain;
    /**
     * 项目价格
     */
    private Double proPrice;
    /**
     * 项目步骤
     */
    private String proStep;
    /**
     * 关联项目类型id
     */
    private Long proTypeId;
    /**
     * 项目名称
     */
    private String proName;
    /**
     * 关联图片id
     */
    private Long imageId;
    /**
     * 项目状态
     */
    private String proStatus;
    /**
     * 关联公司id
     */
    private Long busId;
    
    private Long tecId;

    /**
     * 是否收藏
     */
    private String flag;

    private Image image;
    /**
     * 获取商业数据
     */
    private Business business;

}

