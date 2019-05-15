package net.jiguo.controller;

import io.swagger.annotations.Api;
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
@RequestMapping(value = "use")
@Api(value = "UseController", tags = "use接口")
public class UseController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @ApiOperation(value = "显示play界面", notes = "显示play界面", httpMethod = "GET")
    public String showIndex(){
        return "use/index";
    }


    @RequestMapping(value = "tys",method = RequestMethod.GET)
    @ApiOperation(value = "显示tys界面", notes = "体验式专享", httpMethod = "GET")
    public String showTys(){
        return "use/tys";
    }

    @RequestMapping(value = "sq",method = RequestMethod.GET)
    @ApiOperation(value = "显示sq界面", notes = "体验式专享", httpMethod = "GET")
    public String showSq(){
        return "use/sq";
    }

    @RequestMapping(value = "sy",method = RequestMethod.GET)
    @ApiOperation(value = "显示sy界面", notes = "体验式专享", httpMethod = "GET")
    public String showSy(){
        return "use/sy";
    }

    @RequestMapping(value = "end",method = RequestMethod.GET)
    @ApiOperation(value = "显示end界面", notes = "体验式专享", httpMethod = "GET")
    public String showEnd(){
        return "use/end";
    }

}
