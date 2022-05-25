package com.demo.eshop.sso.filter;



import com.demo.eshop.sso.constant.AuthConst;
import com.demo.eshop.sso.storage.SessionStorage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 客户端登录
 * @date 2022-05-19
 */
public class LoginFilter implements Filter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取配置参数
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();

        //已经登录、放行
        if (session.getAttribute(AuthConst.IS_LOGIN) != null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        // 从认证中心回跳的带有token的请求，有效则放行
        String token = request.getParameter(AuthConst.TOKEN);
        if ( token != null){
            request.setAttribute(AuthConst.IS_LOGIN,true);
            request.setAttribute(AuthConst.TOKEN,token);
            SessionStorage.INSTANCE.set(token,session);
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        // 重定向至登录页面，并附带当前请求地址
        response.sendRedirect(config.getInitParameter(AuthConst.LOGIN_URL) + "?" + AuthConst.CLIENT_URL + "=" + request.getRequestURL());
    }

    @Override
    public void destroy() {

    }
}
