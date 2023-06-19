package com.nfcat.demo_model.service.imp;

import com.nfcat.demo_model.Dao.FriendMapper;
import com.nfcat.demo_model.pojo.Friend;
import com.nfcat.demo_model.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImp implements FriendService {

    @Autowired
    public FriendMapper friendMapper;

    @Override
    public List<Friend> getMyFriends(String username) {
        List<Friend> myFriends = friendMapper.getMyFriends(username);
        return myFriends;
    }
}
