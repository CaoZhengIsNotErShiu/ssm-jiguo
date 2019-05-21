package net.jiguo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.jiguo.model.JgReportThumb;
import net.jiguo.model.JgTryReport;
import net.jiguo.service.ReportServiceI;
import net.jiguo.util.HttpResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/15 下午3:33
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "report")
@Api(value = "ReportController", tags = "report接口")
public class ReportController {

    @Autowired
    private ReportServiceI reportService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @ApiOperation(value = "显示play界面", notes = "显示play界面", httpMethod = "GET")
    public String showIndex(){
        return "/report/index";
    }


    @RequestMapping(value = "hot",method = RequestMethod.GET)
    @ApiOperation(value = "显示hot界面", notes = "显示hot界面", httpMethod = "GET")
    public String showHot(){
        return "/report/hot";
    }

    @RequestMapping(value = "/getReportSelected",method = RequestMethod.GET)
    @ApiOperation(value = "获取报告精选", notes = "获取报告精选", httpMethod = "GET")
    @ResponseBody
    public HttpResult getReportSelected(String user){
        HttpResult httpResult = new HttpResult();
        List<JgTryReport> itemList =  reportService.getReportSelected(user);
        if (CollectionUtils.isNotEmpty(itemList)){
            httpResult.setStatus(200);
            httpResult.setData(itemList);
        }else{
            httpResult.setStatus(500);
            httpResult.setMsg("error");
        }
        return httpResult;
    }


    @RequestMapping(value = "/getReportThumbByUserId",method = RequestMethod.GET)
    @ApiOperation(value = "点赞", notes = "点赞", httpMethod = "GET")
    @ResponseBody
    public HttpResult getReportThumbByUserId(String user, String reportId){
        HttpResult httpResult = new HttpResult();
        int result = reportService.getReportThumbByUserId(user, reportId);
        httpResult.setStatus(200);
        httpResult.setData(result);
        return httpResult;
    }



}
