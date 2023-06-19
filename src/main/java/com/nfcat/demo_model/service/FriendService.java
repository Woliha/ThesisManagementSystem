package com.nfcat.demo_model.service;

import com.nfcat.demo_model.pojo.Friend;

import java.util.List;

public interface FriendService {

    public List<Friend> getMyFriends(String username);
}
