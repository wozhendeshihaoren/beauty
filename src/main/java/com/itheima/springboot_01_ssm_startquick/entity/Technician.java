package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (Technician)实体类
 *
 * @author woshihaoren
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Technician implements Serializable {
    /**
     * 技师id
     */
    private Long id;
    /**
     * 技师简介
     */
    private String techExplain;
    /**
     * 技师姓名
     */
    private String techName;
    /**
     * 关联商家id
     */
    private Long busId;
    /**
     * 技师头像路径
     */
    private String flag;

    private String imageURL;

    private List<Project> projects;

}

