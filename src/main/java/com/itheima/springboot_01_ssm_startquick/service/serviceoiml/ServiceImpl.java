package com.itheima.springboot_01_ssm_startquick.service.serviceoiml;

import com.itheima.springboot_01_ssm_startquick.Mapper.ImageMapper;
import com.itheima.springboot_01_ssm_startquick.entity.Image;
import com.itheima.springboot_01_ssm_startquick.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author woshihaoren
 */
@Service
public class ServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public List<Image> getImageByType(String Type) {
        return imageMapper.getImageByType(Type);
    }
}
