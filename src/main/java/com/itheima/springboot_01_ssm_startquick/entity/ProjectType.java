package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Projecttype)实体类
 *
 * @author woshihaoren
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectType implements Serializable {
    /**
     * 项目类型id
     */
    private Long id;
    /**
     * 项目类型
     */
    private String name;

}

