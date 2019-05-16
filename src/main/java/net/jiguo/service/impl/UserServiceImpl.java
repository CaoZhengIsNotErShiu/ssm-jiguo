package net.jiguo.service.impl;

import net.jiguo.mapper.UserMapper;
import net.jiguo.model.User;
import net.jiguo.service.UserServiceI;
import net.jiguo.util.MD5_Utile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/15 下午5:25
 * @Version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    public User checkLogin(String name, String password) {
        String md5 = MD5_Utile.getMD5(password);
        System.out.println("md5:"+md5);
        return userMapper.checkLogin(name, md5);
    }
}
