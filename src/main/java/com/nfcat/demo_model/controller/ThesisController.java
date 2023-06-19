package com.nfcat.demo_model.controller;


import com.alibaba.fastjson2.JSON;
import com.nfcat.demo_model.pojo.Thesis;

import com.nfcat.demo_model.pojo.test;
import com.nfcat.demo_model.service.ThesisService;

import org.apache.poi.hwpf.HWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/thesis")
public class ThesisController {

    @Autowired
    public ThesisService thesisService;

    @PostMapping("/addthesis")
    public String addThesis(@RequestBody Thesis thesis, @CookieValue("username")String username){
        thesis.uid = username;
        System.out.println("论文信息"+thesis);
        thesis.successtime = LocalDate.now();
        boolean b = thesisService.addThesis(thesis);
        System.out.println(b);
        return "成功提交";
    }

    @GetMapping("/s")
    public String selectAll(){
        List<Thesis> theses = thesisService.selectAll();
        String the = JSON.toJSONString(theses);
        return the;
    }

    @PostMapping("test")
    public String addt(@RequestBody test t){
        System.out.println(t);
        return "123456";
    }

    @PostMapping("/file")
    public String upload(@RequestParam("file") MultipartFile file,@RequestParam("id") String id) throws IOException {
        System.out.println("论文上传的文件来自的用户"+id);

        try {
            String fileName = file.getOriginalFilename();

            Path path2 = Paths.get("");
            System.out.println("Paths打开的路径"+path2);

            Path path = Paths.get("D:\\IDEA\\docs\\" + fileName);
            Path path1 = Paths.get("thesis/"+id+"/"+fileName);

            Files.createDirectories(path1.getParent());
            Files.write(path1, file.getBytes());
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "错误";
        }
    }
}
