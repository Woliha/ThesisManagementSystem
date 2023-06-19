package com.nfcat.demo_model.service.imp;

import com.nfcat.demo_model.Dao.ThesisMapper;
import com.nfcat.demo_model.pojo.Thesis;
import com.nfcat.demo_model.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import java.util.List;

@Service
public class ThesisServiceImp implements ThesisService{

    @Autowired
    public ThesisMapper thesisMapper;

    //根据id查找论文
    @Override
    public Thesis getById(int id) {
        Thesis thesis = thesisMapper.selectById(id);
        return thesis;
    }

    //添加新论文
    @Override
    public boolean addThesis(Thesis thesis) {

        int insert = thesisMapper.insert(thesis);
        System.out.println("添加成功与否:"+insert);
        System.out.println(thesis);
        return true;
    }

    //更新论文信息
    @Override
    public boolean update(Thesis thesis) {

        return false;
    }

    @Override
    public List<Thesis> selectAll() {
        List<Thesis> theses = thesisMapper.selectList(null);
        return theses;
    }
}
