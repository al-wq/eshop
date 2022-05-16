package com.demo.service;

import com.demo.eshop.entities.AdminInfo;

public interface AdminInfoService {
    public AdminInfo login(AdminInfo adminInfo);
    public int register(AdminInfo adminInfo);
}
