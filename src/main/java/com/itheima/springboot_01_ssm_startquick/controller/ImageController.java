package com.itheima.springboot_01_ssm_startquick.controller;

import com.itheima.springboot_01_ssm_startquick.entity.Image;
import com.itheima.springboot_01_ssm_startquick.service.ImageService;
import com.itheima.springboot_01_ssm_startquick.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author woshihaoren
 */
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;
   @GetMapping("image/{type}")
    public List<Image> getImageType( @PathVariable String type) {
        return imageService.getImageByType(type);
    }
}
