package com.nfcat.demo_model.service;

import com.nfcat.demo_model.pojo.Thesis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThesisService {

    public Thesis getById(int id);


    //添加新论文
    public boolean addThesis(Thesis thesis);

    //更改论文信息
    public boolean update(Thesis thesis);

    public List<Thesis> selectAll();
}
