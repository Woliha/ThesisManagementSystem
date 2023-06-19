package com.nfcat.demo_model.pojo;

import lombok.Data;

@Data
public class Userinfo {
//    public String id;
    public String username;  //用户账号
    public String password;     //用户密码
    public String Permissions;  //权限
    public String attach;       //附加
    public String name;           //用户名字

    public String school;       //学院信息
    public String specialized;   //专业信息
}
