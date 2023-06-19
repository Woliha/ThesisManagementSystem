package com.nfcat.demo_model.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfcat.demo_model.pojo.PaperDownload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperDownloadMapper extends BaseMapper<PaperDownload> {

    @Select("select * from paperdownload where paperid = ${paperid}")
    public List<PaperDownload> getByPaperId(Integer paperid);
}
