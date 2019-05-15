package net.jiguo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/15 下午3:33
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "guid")
public class GuidController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @ApiOperation(value = "显示play界面", notes = "显示play界面", httpMethod = "GET")
    public String showIndex(){
        return "guid/index";
    }

    @RequestMapping(value = "hot",method = RequestMethod.GET)
    @ApiOperation(value = "显示hot界面", notes = "显示hot界面", httpMethod = "GET")
    public String showHot(){
        return "guid/hot";
    }
}
