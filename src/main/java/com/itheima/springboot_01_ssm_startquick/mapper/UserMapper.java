package com.itheima.springboot_01_ssm_startquick.mapper;

import com.itheima.springboot_01_ssm_startquick.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author woshihaoren
 */
@Mapper
public interface UserMapper {

    /**
     * 校验用户的电话号码是否为空
     * @param user
     * @return
     */
    List<User> getByPhone(String user);

    /**
     * 添加用户账号
     * @param user
     */
    void insert(User user);

    /**
     * 更新用户sessionKey,openId,token的状态
     * @param user
     */
     void updateUser(User user);
}
