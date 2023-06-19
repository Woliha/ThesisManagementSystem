package com.nfcat.demo_model.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfcat.demo_model.pojo.Userinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<Userinfo> {

}
