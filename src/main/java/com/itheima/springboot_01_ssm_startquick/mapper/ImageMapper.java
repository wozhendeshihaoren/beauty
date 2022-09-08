package com.itheima.springboot_01_ssm_startquick.mapper;

import com.itheima.springboot_01_ssm_startquick.entity.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author woshihaoren
 */
@Mapper
public interface ImageMapper {
    /**
     * 根据类型查询图片
     * @param type
     * @return
     */
    List<Image> getImageByType(String type);
}
