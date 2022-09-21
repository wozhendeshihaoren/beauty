package com.itheima.springboot_01_ssm_startquick.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Image)实体类
 *
 * @author woshihaoren
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    /**
     * 图片id
     */
    private Long id;
    /**
     * 图片路径
     */
    private String imageURL;
    /**
     * 图片标题
     */
    private String imageTitle;
    /**
     * 图片类型 banner：首页轮播图 nav：菜单 head：头像
     */
    private String imageType;
    /**
     * 图片状态  1：可用  0：不可用
     */
    private String imageState;

}

