package com.nfcat.demo_model.service;
import com.nfcat.demo_model.pojo.Userinfo;

import java.util.List;

public interface UserService {

    //获取全部
    public List<Userinfo> getAll();
    //根据id获取user
    public Userinfo getById(int id);
    //根据Username获取user
    public Userinfo getByUsername(String username);
    //添加新用户
    public String addUserinfo(Userinfo userinfo);

    public Void updataUserinfo(Userinfo userinfo);
}
