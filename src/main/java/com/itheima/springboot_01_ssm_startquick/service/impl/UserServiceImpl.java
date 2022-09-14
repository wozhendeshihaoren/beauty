package com.itheima.springboot_01_ssm_startquick.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.itheima.springboot_01_ssm_startquick.entity.User;
import com.itheima.springboot_01_ssm_startquick.mapper.UserMapper;
import com.itheima.springboot_01_ssm_startquick.resp.RespCode;
import com.itheima.springboot_01_ssm_startquick.resp.RespModel;
import com.itheima.springboot_01_ssm_startquick.service.UserService;
import com.itheima.springboot_01_ssm_startquick.util.HttpClientUtil;
import com.itheima.springboot_01_ssm_startquick.util.StringCheckUtil;
import com.itheima.springboot_01_ssm_startquick.vo.LoginDate;
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
              if (!StringCheckUtil.isMobile(phone)) {
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

    @Override
    public RespModel login(LoginDate loginDate) {
       try {

        String code = loginDate.getCode();
        String phone = loginDate.getPhone();
        String password = loginDate.getPassword();

           System.out.println(password);
        //校验code、phone、password是否为空和格式是否正确

        if(StringCheckUtil.isEmpty(phone)) {
            return  new RespModel(RespCode.FAIL_4,null);
        }

        if(!StringCheckUtil.isMobile(phone)) {
            return  new RespModel(RespCode.FAIL_3,null);
        }
        if(StringCheckUtil.isEmpty(password)) {
            return  new RespModel(RespCode.FAIL_2,null);
        }
        //校验密码是否匹配

        List<User> users = userMapper.getByPhone(phone);

        Md5Hash _password = new Md5Hash(password, "huahui", 10);

        User user = users.get(0);
        //如果加密过后的密码不匹配，则返回账号或密码错误
        if(!user.getPassword().equals(_password.toString())) {
            return new RespModel(RespCode.ERROR_6,null);
        }
        //通过code获取token和sessionkey
         String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx653c4fc62caffeb9&secret=d7d52df9880c02342c2639df6e7d8dba&js_code=" + code + "&grant_type=authorization_code";
        String s = HttpClientUtil.doGet(url);
        JSONObject parse = (JSONObject) JSONObject.parse(s);
        String session_key = (String) parse.get("session_key");
        String openid = (String) parse.get("openid");
        //自定义token
        Md5Hash md5Hash = new Md5Hash(session_key, openid, 10);
        String token = md5Hash.toString();
        user.setSessionKey(session_key);
        user.setOpenId(openid);
        user.setToken(token);
        userMapper.updateUser(user);
         return new RespModel(RespCode.SUCCESS_2,user);
       }catch (Exception e) {
           e.printStackTrace();
           return new RespModel(RespCode.FAIL,null);
       }

    }
}
