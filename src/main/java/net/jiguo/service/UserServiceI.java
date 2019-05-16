package net.jiguo.service;

import net.jiguo.model.User;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/15 下午5:24
 * @Version 1.0
 */
public interface UserServiceI {
    //登陆
    User checkLogin(String name, String password);
}
