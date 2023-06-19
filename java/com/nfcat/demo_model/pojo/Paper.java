package com.nfcat.demo_model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableName("Thesis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paper {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer paperID;


    //-------------------------------------------
    private String title;
    @TableField(value = "Abstract1")
    private String Abstract;

    private String type;
    @TableField(value = "specialized")
    private String major;

    private Integer pages;
    @TableField(value = "score")
    private Float score;
    private String author;
    @TableField(value = "teacher")
    private String advisor;

    @TableField(value = "downloadnumb")
    private Integer downloadTime;

    //-------------------------------------------
    private String src;
    private String uid;
    @TableField(exist = false)
    public Integer page;


}