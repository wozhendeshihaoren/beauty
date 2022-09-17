package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author woshihaoren
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {

    private Integer id;

    private String imageURL;

    private String techExplain;

    private  String techName;

    private String flag;

    private  Integer tid;
}
