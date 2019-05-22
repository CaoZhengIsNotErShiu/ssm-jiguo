package net.jiguo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.jiguo.model.VO.JgGuideVO;
import net.jiguo.service.GuideServiceI;
import net.jiguo.util.HttpResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/15 下午3:33
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "guid")
@Api(value = "GuidController", tags = "guid接口")
public class GuidController {

    @Autowired
    private GuideServiceI guideService;

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

    @RequestMapping(value = "newest",method = RequestMethod.GET)
    @ApiOperation(value = "显示最新newest界面", notes = "显示newest界面", httpMethod = "GET")
    @ResponseBody
    public HttpResult getGuideNewest(@RequestParam(value="pn",defaultValue="1")Integer pn){
        HttpResult result = new HttpResult();
        PageHelper.startPage(pn,16);
        List<JgGuideVO> jgGuideVOList =  guideService.getGuideNewest();
        if (CollectionUtils.isNotEmpty(jgGuideVOList)){
            PageInfo pageInfo = new PageInfo(jgGuideVOList,5);
            result.setStatus(200);
            result.setData(pageInfo);
        }else {
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }
}
