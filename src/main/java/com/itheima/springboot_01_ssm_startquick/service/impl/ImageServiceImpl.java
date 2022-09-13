package com.itheima.springboot_01_ssm_startquick.service.impl;

import com.itheima.springboot_01_ssm_startquick.mapper.ImageMapper;
import com.itheima.springboot_01_ssm_startquick.entity.Image;
import com.itheima.springboot_01_ssm_startquick.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author woshihaoren
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public List<Image> getImageByType(String type) {
        return imageMapper.getImageByType(type);
    }
}
