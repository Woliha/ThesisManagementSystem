package com.nfcat.demo_model.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nfcat.demo_model.Dao.UserMapper;
import com.nfcat.demo_model.pojo.Userinfo;
import com.nfcat.demo_model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserMapper userMapper;

    //获取所有用户信息
    @Override
    public List<Userinfo> getAll() {
        List<Userinfo> list = userMapper.selectList(null);
        return list;
    }

    @Override
    public Userinfo getById(int id) {
        Userinfo user = userMapper.selectById(id);
        return user;
    }

    //根据账号查询用户
    @Override
    public Userinfo getByUsername(String username) {
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
        queryWrapper.eq("username",username);
        Userinfo userinfo = userMapper.selectOne(queryWrapper);
        return userinfo;
    }

    //添加用户信息
    @Override
    public String addUserinfo(Userinfo userinfo) {
        userMapper.insert(userinfo);
        return "success";
    }

    //用户信息更新
    @Override
    public Void updataUserinfo(Userinfo userinfo) {
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
        queryWrapper.eq("username",userinfo.username);
        userMapper.update(userinfo,queryWrapper);
        return null;
    }
}
