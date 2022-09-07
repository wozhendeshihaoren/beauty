package com.itheima.springboot_01_ssm_startquick;

import com.itheima.springboot_01_ssm_startquick.Mapper.ImageMapper;
import com.itheima.springboot_01_ssm_startquick.entity.Image;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SSMApplicationTests {

    @Resource
    private ImageMapper imageMapper;
    @Test
    void contextLoads() {
        System.out.println(imageMapper.getImageByType("nav"));
    }

}
