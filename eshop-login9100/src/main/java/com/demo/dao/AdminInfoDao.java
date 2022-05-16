package com.demo.dao;

import com.demo.eshop.entities.AdminInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description 管理员信息
 * @date 2022-05-14
 */
@Mapper
public interface AdminInfoDao {
    //通过用户名密码查询用户
    public AdminInfo SelectByNameByPasswd(AdminInfo adminInfo);
    public int createAdminInfo(AdminInfo adminInfo);
}
