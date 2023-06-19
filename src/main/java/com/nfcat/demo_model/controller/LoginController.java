package com.nfcat.demo_model.controller;


import com.nfcat.demo_model.pojo.Userinfo;
import com.nfcat.demo_model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public UserService userService;


    @ResponseBody
    @GetMapping("/test")
    public String testapi(){
        System.out.println("测试接口");
        return "success";
    }


    //正式的登陆，前端点击登录按钮后这里接收登录数据
    @PostMapping("/log")
    @ResponseBody
    public String Login(@RequestBody Userinfo user , HttpServletResponse resp){

        //验证是否登录成功
        Userinfo byUsername = userService.getByUsername(user.username);
        System.out.println("查询登录账号结果:"+byUsername);
        System.out.println("请求登录的账号:"+user);
        if (byUsername == null){
            return "账号不存在,请注册账号";
        }
        if(!byUsername.password.equals(user.password)){
            return "输入的账号或密码不正确";
        }

        //到这里就是登录成功
        //为了标注以后的操作是出自哪个用户，我们用用户名当作cookie
        Cookie cookie1 = new Cookie("username",user.username);
        cookie1.setMaxAge(86400);
        cookie1.setPath("/");
        resp.addCookie(cookie1);
        return "登录成功";
    }

    //正式的注册
    @PostMapping("/reg")
    @ResponseBody
    public String Register(@RequestBody Userinfo userinfo){
        System.out.println("注册账号的信息:"+userinfo);
        if (userinfo.username.equals("")){
            return "账号不能为空,请输入你要注册的账号";
        }
        if(userinfo.password.equals("")){
            return "密码不能为空,请输入你要注册的密码";
        }
        System.out.println("账号长度:"+userinfo.username.length());
        if ((userinfo.username.length()<7 || userinfo.username.length() >16)){
            return "账号格式不正确,长度在7~16个字符之间";
        }
        if ((userinfo.password.length()<6 || userinfo.password.length() >16)){
            return "密码格式不正确,长度在6~16个字符之间";
        }
        Userinfo byUsername = userService.getByUsername(userinfo.username);

        if(byUsername != null){
            return "账号已经存在,请换个账号注册";
        }

        String s = userService.addUserinfo(userinfo);
        return "注册成功";
    }
}
