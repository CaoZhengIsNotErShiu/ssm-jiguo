package net.jiguo.model;

import lombok.Data;

/**
 * @Disc 用户实体类
 * @Author caozheng
 * @Date: 19/5/15 下午5:16
 * @Version 1.0
 */
@Data
public class User {

    private int id;
    private String name;
    private String password;
    private int state;


}
