package com.demo.eshop.sso.filter;

import com.demo.eshop.sso.constant.AuthConst;
import com.demo.eshop.sso.storage.SessionStorage;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 客户端退出
 * @date 2022-05-19
 */
public class LoginOut implements Filter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();

        String logoutUrl = config.getInitParameter(AuthConst.LOGOUT_URL);
        String token = (String)session.getAttribute(AuthConst.TOKEN);
        //主动退出
        if ("/logout".equals(request.getRequestURI())){
            // 注销后重定向
            response.sendRedirect("/test");
            // 注销本地会话
            session = SessionStorage.INSTANCE.get(token);
            if (session != null) {
                session.invalidate();
            }
            return;
        }
        //被动退出
    }

    @Override
    public void destroy() {

    }
}
