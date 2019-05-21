package net.jiguo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.jiguo.model.JgTryItem;
import net.jiguo.model.JgTryReport;
import net.jiguo.service.IndexServiceI;
import net.jiguo.util.HttpResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/14 下午3:08
 * @Version 1.0
 */
@Controller
@Api(value = "IndexController", tags = "首页接口")
public class IndexController {

    @Autowired
    private IndexServiceI indexService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @ApiOperation(value = "显示首页界面", notes = "显示首页界面", httpMethod = "GET")
    public String showIndex(){
        return "index";
    }

    @RequestMapping(value = "/getHotUse",method = RequestMethod.GET)
    @ApiOperation(value = "获取热门试用", notes = "获取热门试用", httpMethod = "GET")
    @ResponseBody
    public HttpResult getHotUse(){
        HttpResult httpResult = new HttpResult();
        List<JgTryItem> itemList =  indexService.getHotUse();
        if (CollectionUtils.isNotEmpty(itemList)){
            httpResult.setStatus(200);
            httpResult.setData(itemList);
        }else{
            httpResult.setStatus(500);
            httpResult.setMsg("error");
        }
        return httpResult;
    }


}
