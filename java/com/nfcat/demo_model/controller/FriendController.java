package com.nfcat.demo_model.controller;

import com.nfcat.demo_model.pojo.Friend;
import com.nfcat.demo_model.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("friend")
public class FriendController {

    @Autowired
    public FriendService friendService;

    @GetMapping("f")
    public List<Friend> getMyFriends(@RequestParam("username") String username){
        System.out.println("收到的前端请求发来的参数:"+username);
        List<Friend> myFriends = friendService.getMyFriends(username);
        return myFriends;
    }
}
