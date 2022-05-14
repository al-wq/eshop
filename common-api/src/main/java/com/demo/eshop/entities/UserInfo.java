package com.demo.eshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @description 用户信息管理类
 * @date 2022-05-15
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private String sex;
    private String address;
    private String email;
    private Date regDate;
    private Integer status;
}
