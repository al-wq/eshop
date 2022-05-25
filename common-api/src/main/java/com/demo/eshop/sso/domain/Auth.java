package com.demo.eshop.sso.domain;

import lombok.Data;

/**
 * 授权对象
 * @date 2022-05-19
 */
@Data
public class Auth {
    //授权用户
    private User user;
    //随机码
    private String code;
    //过期时间
    private String expire;
}
