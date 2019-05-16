package net.jiguo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.jiguo.model.User;
import net.jiguo.service.UserServiceI;
import net.jiguo.util.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private UserServiceI userService;

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

    //表单提交过来的路径
    @RequestMapping("/checkLogin")
    @ResponseBody
    public HttpResult checkLogin(User user, HttpSession session, HttpServletResponse response){
        HttpResult httpResult = new HttpResult();
        //调用service方法
        user = userService.checkLogin(user.getName(), user.getPassword());
        //若有user则添加到model里并且跳转到成功页面
        if(user != null || user.equals("")){
            session.setAttribute("USER_SESSION", user);
            Cookie cookie=new Cookie("IMcookie", user.getId()+"-"+user.getName());
            cookie.setMaxAge(3*24*60*60); //三天
            response.addCookie(cookie);
            httpResult.setStatus(200);
            httpResult.setMsg("success");
        }else {
            session.setAttribute("msg", "用户名或密码错误，请重新登录！");
            httpResult.setStatus(500);
            httpResult.setMsg("error");
        }
        return httpResult;

    }
}
