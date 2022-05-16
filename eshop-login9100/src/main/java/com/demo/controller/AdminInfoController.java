package com.demo.controller;

import com.demo.eshop.entities.AdminInfo;
import com.demo.eshop.entities.CommonResult;
import com.demo.service.AdminInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;

@RestController
@RequestMapping(value="/adminInfo")
@Slf4j
@Api(value = "登录管理类",description = "用来管理用户的登录、注册、注销等")
public class AdminInfoController {
    @Resource
    private AdminInfoService adminInfoService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @ApiOperation(value = "登录接口")
    @PostMapping("/login")
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

    /**
     * 注册
     * @param adminInfo
     * @return
     */
    @PostMapping("/register")
    public CommonResult register(AdminInfo adminInfo){
        String message = null;
        int result = adminInfoService.register(adminInfo);
        if (result > 0){
            message = "注册成功";
            return new CommonResult(200,message);
        }else {
            message = "注册失败";
            return new CommonResult(200,message);
        }
    }

    /**
     * 注销
     * @param status
     * @return
     */
    @GetMapping("/logout")
    public CommonResult logout(SessionStatus status){
        status.setComplete();
        return new CommonResult(200,"注销成功");
    }
}
