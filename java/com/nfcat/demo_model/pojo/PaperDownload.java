package com.nfcat.demo_model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@TableName("paperdownload")
@Data
@AllArgsConstructor
public class PaperDownload {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer paperID;
    private String username;
    private LocalDateTime time;

}

