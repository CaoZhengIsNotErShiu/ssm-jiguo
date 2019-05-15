package net.jiguo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/14 下午3:08
 * @Version 1.0
 */
@Controller
@Api(value = "IndexController", tags = "首页接口")
public class IndexController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @ApiOperation(value = "显示首页界面", notes = "显示首页界面", httpMethod = "GET")
    public String showIndex(){
        return "index";
    }
}
