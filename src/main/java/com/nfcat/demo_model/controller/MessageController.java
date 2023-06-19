package com.nfcat.demo_model.controller;

import com.nfcat.demo_model.pojo.Message;
import com.nfcat.demo_model.pojo.MessageUsernames;
import com.nfcat.demo_model.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    public MessageService messageService;

    @GetMapping("/t")
    public String test(){
        return "success";
    }

    @PostMapping("/meg")
    public List<Message> getMessage(@RequestBody MessageUsernames messageUsernames){
        System.out.println("传送过来的对象:"+messageUsernames);
        List<Message> messageByUsername = messageService.getMessageByUsername(messageUsernames.username1, messageUsernames.username2);
//        System.out.println("查询后的对象"+messageByUsername);
        return messageByUsername;
    }

    //接收前端发送来的消息
    @PostMapping("/send")
    public String addMessage(@RequestBody Message message, Model model){


        String _username = message.username1;
        message.username1 = message.username2;
        message.username2 = _username;
        System.out.println("收到用户消息:"+message);
        String s = messageService.addMessage(message);
        return s;
    }
}
