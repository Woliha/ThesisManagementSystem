package com.nfcat.demo_model.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfcat.demo_model.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {

    @Select("select * from message where (username1 = ${username1} and username2 = ${username2}) or (username1 = ${username2} and username2 = ${username1})")
    public List<Message> getMessageByUsername(String username1,String username2);
}
