package net.jiguo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/15 下午2:23
 * @Version 1.0
 */
@Controller
@Api(value = "/UserController", tags = "User接口")
public class UserController {

    //private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ApiOperation(value = "展示登陆界面", notes = "展示登陆界面", httpMethod = "GET")
    public String login(){
        return "login";
    }


    @RequestMapping(value = "regist",method = RequestMethod.GET)
    @ApiOperation(value = "展示注册界面", notes = "展示注册界面", httpMethod = "GET")
    public String showRegist(){
        return "regist";
    }
}
