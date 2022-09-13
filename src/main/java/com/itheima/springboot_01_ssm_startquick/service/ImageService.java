package com.itheima.springboot_01_ssm_startquick.service;

import com.itheima.springboot_01_ssm_startquick.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author woshihaoren
 */
public interface ImageService {

    /***
     * 得到一个image的数据列表
     * @param Type
     * @return
     */

    public List<Image> getImageByType( String Type);
}
