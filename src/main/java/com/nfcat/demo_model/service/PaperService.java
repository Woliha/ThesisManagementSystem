package com.nfcat.demo_model.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfcat.demo_model.pojo.*;

import java.util.List;

public interface PaperService extends IService<Paper> {
    public Pages rankByDownload(Integer page);

    public TongJi tongJi();

    List<Paper> getAllPaper();

    void addPaper(Paper paper);

    Paper getPaperById(Integer id);

    void updatePaper(Paper paper);

    void deletePaper(Integer id);

    String getSrcByID(Integer id);

    void countDownload(Integer id);

    Integer getCPaper();

    Integer getPaperNum();


    Pages searchPaper(String title, String author, String teacher,Integer page);


    List<Paper> getUserByUid(String uid);

    public Pages getPaperPage();

    public List<PaperDownload> selectDownload(Integer id);

    void saveDownload(PaperDownload paperDownload);

}
