package com.nfcat.demo_model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Data
public class Thesis {

    @TableId(value = "id", type = IdType.AUTO)
    public String id;
    public String title;
    public String author;
    public String abstract1;
    public String teacher;
    public String type;
    public String specialized;
    public int pages;
    public int score;
    public LocalDate successtime;
    public String uid;
    public String src;


}
