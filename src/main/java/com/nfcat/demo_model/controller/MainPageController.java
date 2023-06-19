package com.nfcat.demo_model.controller;

import com.nfcat.demo_model.pojo.MainUserTest;
import com.nfcat.demo_model.pojo.Userinfo;
import com.nfcat.demo_model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainPageController {

    @Autowired
    public UserService userService;

    @PostMapping("/t")
    public String test(@RequestBody Userinfo userinfo, @CookieValue("username") String cookie){
        userinfo.username = cookie;
        System.out.println("收到用户信息更新请求:");
        System.out.println(userinfo);
        userService.updataUserinfo(userinfo);
        return "success";
    }
}
