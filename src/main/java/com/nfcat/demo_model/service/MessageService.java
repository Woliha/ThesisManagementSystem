package com.nfcat.demo_model.service;

import com.nfcat.demo_model.Dao.MessageMapper;
import com.nfcat.demo_model.pojo.Message;


import java.util.List;


public interface MessageService {

    public List<Message> getMessageByUsername(String username1,String username2);

    public String addMessage(Message message);
}
