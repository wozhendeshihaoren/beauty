package com.itheima.springboot_01_ssm_startquick.controller;

import com.itheima.springboot_01_ssm_startquick.entity.Image;
import com.itheima.springboot_01_ssm_startquick.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author woshihaoren
 */
@RestController
public class ImageController {

    @Autowired

    private ServiceImpl serviceImpl;
    @GetMapping("image/{type}")
    public List<Image> getImageType(@PathVariable String type) {
        return serviceImpl.getImageByType(type);
    }
}
