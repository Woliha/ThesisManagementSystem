package com.nfcat.demo_model.service.imp;

import com.nfcat.demo_model.Dao.MessageMapper;
import com.nfcat.demo_model.pojo.Message;
import com.nfcat.demo_model.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService {

    @Autowired
    public MessageMapper messageMapper;

    @Override
    public List<Message> getMessageByUsername(String username1,String username2) {
        List<Message> messageByUsername = messageMapper.getMessageByUsername(username1,username2);
        return messageByUsername;
    }

    @Override
    public String addMessage(Message message) {
        messageMapper.insert(message);
        return "success";
    }
}
