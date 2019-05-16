package net.jiguo.interator;

import net.jiguo.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Disc
 * @Author caozheng
 * @Date: 19/5/16 上午11:28
 * @Version 1.0
 */
public class LoginInterator implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        Cookie[] cookies=request.getCookies();
        Boolean iscook=false;
        if(cookies!=null) {
            for(Cookie cookie:cookies) {
                // 存在user
                if("user".equals(cookie.getName())) {
                    // 设置登录用户
                    HttpSession session=request.getSession();
                    String string=cookie.getValue();
                    String[] strings=string.split("-");
                    User user=new User();
                    user.setId(Integer.valueOf(strings[0]));
                    user.setName(strings[1]);
                    session.setAttribute("USER_SESSION", user);
                    // 重定向
//                    redirect(request, response);
                    iscook=true;
                }
            }
            // 存在Cookies，但没有"user"
            if(iscook==false)
                request.getRequestDispatcher("/login").forward(request, response);
        }else {
            request.setAttribute("msg", "您还没有登录，请先登录！");
            request.getRequestDispatcher("/login.html").forward(request, response);
        }
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    //对于请求是ajax请求重定向问题的处理方法
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取当前请求的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+request.getContextPath();
        //如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理 否则直接重定向就可以了
        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            //告诉ajax我是重定向
            response.setHeader("REDIRECT", "REDIRECT");
            //告诉ajax我重定向的路径
            response.setHeader("CONTENTPATH", basePath+"/index.html");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }else{
            response.sendRedirect(basePath + "/index.html");
        }
    }

}
