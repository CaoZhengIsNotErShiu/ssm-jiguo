package net.jiguo.controller;

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
public class IndexController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String testIndex(){
        return "index";
    }
}
