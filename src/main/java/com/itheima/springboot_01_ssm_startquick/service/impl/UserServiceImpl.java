package com.itheima.springboot_01_ssm_startquick.service.impl;

import com.itheima.springboot_01_ssm_startquick.entity.User;
import com.itheima.springboot_01_ssm_startquick.mapper.UserMapper;
import com.itheima.springboot_01_ssm_startquick.resp.RespCode;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.UserService;
import com.itheima.springboot_01_ssm_startquick.util.StringCheckUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author woshihaoren
 *
 * 1.校验用户是否为空
 * 2.校验密码是否为空
 * 3.校验号码是否合格
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public RespModel register(User user) {
          try {
              String username = user.getUsername();
              String password = user.getPassword();
              String phone = user.getPhone();

              if (StringCheckUtil.isEmpty(username)) {
                  return new RespModel(RespCode.FAIL_1, null);
              }
              if (StringCheckUtil.isEmpty(password)) {
                  return new RespModel(RespCode.FAIL_2, null);
              }
              if (StringCheckUtil.isMobile(phone)) {
                  return new RespModel(RespCode.FAIL_3, null);
              }
              if (StringCheckUtil.isEmpty(phone)) {
                  return new RespModel(RespCode.FAIL_4, null);
              }
              List<User> byPhone = userMapper.getByPhone(phone);
              if (byPhone.size() > 0) {
                  return new RespModel(RespCode.ERROR_5, null);
              }
              Md5Hash md5Hash = new Md5Hash(password, "huahui", 10);
              String _password = md5Hash.toString();
              user.setPassword(_password);
              // 第四步：存入数据库
              userMapper.insert(user);
              return new RespModel(RespCode.SUCCESS_1, user);
          }catch (Exception e) {
              e.printStackTrace();
              return new RespModel(RespCode.FAIL,null);
          }

    }
}
