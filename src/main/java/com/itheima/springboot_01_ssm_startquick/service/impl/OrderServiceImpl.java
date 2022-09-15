package com.itheima.springboot_01_ssm_startquick.service.impl;

import com.itheima.springboot_01_ssm_startquick.entity.Order;
import com.itheima.springboot_01_ssm_startquick.entity.User;
import com.itheima.springboot_01_ssm_startquick.mapper.OrderMapper;
import com.itheima.springboot_01_ssm_startquick.mapper.UserMapper;
import com.itheima.springboot_01_ssm_startquick.resp.RespCode;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.OrderService;
import com.itheima.springboot_01_ssm_startquick.util.StringCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *订单实现类
 * @author woshihaoren
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public RespModel createOrder(String token, Order order) {
        try {
            // 用户输入校验
            if (StringCheckUtil.isEmpty(order.getUserName())){
                return new RespModel(RespCode.FAIL_1,null);
            }
            if (StringCheckUtil.isEmpty(order.getUserTell())){
                return new RespModel(RespCode.FAIL_4,null);
            }
            if (!StringCheckUtil.isMobile(order.getUserTell())){
                return new RespModel(RespCode.FAIL_3,null);
            }

            // 获取openid
            List<User> users = userMapper.getUserByToken(token);
            String openid = users.get(0).getOpenId();
            System.out.println(users.get(0));
            order.setOpenId(openid);
            order.setOrderState("0");

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            order.setPlaceDate(date);

            orderMapper.insert(order);

            return new RespModel(RespCode.SUCCESS_3,null);
        }catch (Exception e){
            e.printStackTrace();
            return new RespModel(RespCode.FAIL,null);
        }

    }

}
