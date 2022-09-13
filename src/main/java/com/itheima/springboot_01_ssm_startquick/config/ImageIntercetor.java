//package com.itheima.springboot_01_ssm_startquick.config;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author woshihaoren
// */
//public class ImageIntercetor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String type = (String) request.getAttribute("type");
//        if(type == "nav"){
//           return true;
//        }
//        return false;
//    }
//}
