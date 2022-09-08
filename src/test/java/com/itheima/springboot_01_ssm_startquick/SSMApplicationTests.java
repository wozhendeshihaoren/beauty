package com.itheima.springboot_01_ssm_startquick;

import com.itheima.springboot_01_ssm_startquick.mapper.ImageMapper;
import com.itheima.springboot_01_ssm_startquick.mapper.ProjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SSMApplicationTests {

    @Resource
    private ProjectMapper projectMapper;
    @Test
    void contextLoads() {
        System.out.println(projectMapper.getAllProject());
    }

}
