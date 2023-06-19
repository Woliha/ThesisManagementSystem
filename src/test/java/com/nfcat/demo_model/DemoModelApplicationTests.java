package com.nfcat.demo_model;

import com.nfcat.demo_model.Dao.UserMapper;
import com.nfcat.demo_model.pojo.Thesis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class DemoModelApplicationTests {

    @Autowired
    public UserMapper userMapper;

    @Test
    void contextLoads() throws IOException {

        String finalsrc="./thesis//12345601//python-2021练习题.docx";

//创建输入流
        InputStream is = new FileInputStream(finalsrc);
//创建字节数组
        byte[] bytes = new byte[is.available()];
//将流读到字节数组中
        is.read(bytes);
//创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
//设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.txt");
//设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
//创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
//关闭输入流
        is.close();

    }

}
