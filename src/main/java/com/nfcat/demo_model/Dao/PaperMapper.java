package com.nfcat.demo_model.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfcat.demo_model.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {

    void countDownload(@Param("id") Integer id);

    List<Paper> rankByDownload(@Param("page") Integer page);

    //List<School> searchSchool(@Param("school") String school);

    Float getCount(@Param("school") String school);

    Float getYouXiu(@Param("school") String school);

    Float getJiGe(@Param("school") String school);
}
