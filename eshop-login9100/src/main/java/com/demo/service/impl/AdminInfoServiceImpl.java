package com.demo.service.impl;

import com.demo.dao.AdminInfoDao;
import com.demo.eshop.entities.AdminInfo;
import com.demo.service.AdminInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @date 2022-05-14
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Resource
    private AdminInfoDao adminInfoDao;

    /**
     * 登录验证
     * @param adminInfo
     * @return
     */
    @Override
    public AdminInfo login(AdminInfo adminInfo) {
        return adminInfoDao.SelectByNameByPasswd(adminInfo);
    }
}
