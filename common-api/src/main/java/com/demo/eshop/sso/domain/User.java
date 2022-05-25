package com.demo.eshop.sso.domain;

import lombok.Data;

/**
 * 用户
 * @date 2022-05-19
 */
@Data
public class User {
    //id
    private Integer id;
    //用户名称
    private String username;
    //密码
    private String password;
}
