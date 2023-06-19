package com.nfcat.demo_model.Dao;

import com.nfcat.demo_model.pojo.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FriendMapper {

    @Select("select friend from friends where username = ${username} ")
    public List<Friend> getMyFriends(String username);
}
