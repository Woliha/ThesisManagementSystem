package com.nfcat.demo_model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageForward {

    @GetMapping("/login")
    public String LoginPage(){
        return "redirect:login.html";
    }

    @GetMapping("/apppage")
    public String AppPage(){
        return "redirect:app.html";
    }

}
