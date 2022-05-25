package com.demo.eshop.sso.constant;

/**
 * 授权过程中涉及到的常量字符串
 * @date 2022-05-19
 */
public interface AuthConst {
    // 会话是否授权标志
    String IS_LOGIN = "isLogin";
    // 登录中心url
    String LOGIN_URL = "loginUrl";
    // 注销url
    String LOGOUT_URL = "logoutUrl";
    // 客户端url
    String CLIENT_URL = "clientUrl";
    // 授权令牌
    String TOKEN = "token";
    // 注销请求
    String LOGOUT_REQUEST = "logoutRequest";
}
