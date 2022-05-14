package com.demo.controller;

import com.demo.eshop.entities.AdminInfo;
import com.demo.eshop.entities.CommonResult;
import com.demo.service.AdminInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value="/adminInfo")
@Slf4j
public class AdminInfoController {
    @Resource
    private AdminInfoService adminInfoService;

    @GetMapping("/login")
    public CommonResult login(@RequestParam("username")String username, @RequestParam("password")String password){
        log.debug("获取到登录信息，用户名为："+username+"密码为：" +password);
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setUsername(username);
        adminInfo.setPassword(password);
        AdminInfo adminInfo1 = adminInfoService.login(adminInfo);
        String message = null;
        if (adminInfo1 != null){
            message = "登录成功";
            log.info("登录成功");
        }else {
            message = "用户名或密码错误！！";
            log.info("用户名或密码错误！！");
        }
        return new CommonResult(200,message);
    }
}
