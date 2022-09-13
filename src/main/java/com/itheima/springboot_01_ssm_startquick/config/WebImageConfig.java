package com.itheima.springboot_01_ssm_startquick.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 访问 resources/static/ 下图片路径映射
 * 使用此配置，当在浏览器访问 ：http://localhost:8080/static/banner_01.png
 * 即可访问到 resources/static/banner_01.png 的图片
 * @author qin
 * @create 2022--08--05--11:03
 */
@Configuration
public class WebImageConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射static路径的请求到static目录下
        // 静态资源访问路径和存放路径配置
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // swagger访问配置
        //registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/");
        //通过image访问本地的图片
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    /**
     * image配置拦截器
     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new ImageIntercetor());
//        interceptorRegistration.addPathPatterns("/image/*");
//    }
}
