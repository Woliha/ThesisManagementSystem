package com.nfcat.demo_model.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nfcat.demo_model.Dao.PaperDownloadMapper;
import com.nfcat.demo_model.Dao.PaperMapper;
import com.nfcat.demo_model.pojo.*;
import com.nfcat.demo_model.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper,Paper> implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private PaperDownloadMapper paperDownloadMapper;

    @Override
    public TongJi tongJi(){

        //文法
        Float count1 = paperMapper.getCount("文法学院");
        Float youXiu1 = paperMapper.getYouXiu("文法学院");
        Float jiGe1 = paperMapper.getJiGe("文法学院");
        Float a1=youXiu1/count1;
        Float b1=jiGe1/count1;

        //理学院
        Float count2 = paperMapper.getCount("理学院");
        Float youXiu2 = paperMapper.getYouXiu("理学院");
        Float jiGe2 = paperMapper.getJiGe("理学院");
        Float a2=youXiu2/count2;
        Float b2=jiGe2/count2;
        //工程学院
        Float count3 = paperMapper.getCount("工程学院");
        Float youXiu3 = paperMapper.getYouXiu("工程学院");
        Float jiGe3 = paperMapper.getJiGe("工程学院");
        Float a3=youXiu3/count3;
        Float b3=jiGe3/count3;
        //信息学院
        Float count4 = paperMapper.getCount("信息学院");
        Float youXiu4 = paperMapper.getYouXiu("信息学院");
        Float jiGe4 = paperMapper.getJiGe("信息学院");
        Float a4=youXiu4/count4;
        Float b4=jiGe4/count4;
        TongJi tongJi = new TongJi(a1, a2, a3, a4, b1, b2, b3, b4);
        return tongJi;


    }


    @Override
    public Pages rankByDownload(Integer page) {
        List<Paper> papers= paperMapper.rankByDownload(page);
        Integer num = paperMapper.selectCount(null);
        Pages pages = new Pages(papers, num);
        return pages;
    }

    @Override
    public List<Paper> getAllPaper() {
      //  LambdaQueryWrapper<Paper> wrapper=new LambdaQueryWrapper<>();
        List<Paper> papers = paperMapper.selectList(null);

        return papers;
    }
    public Pages getPaperPage() {
        LambdaQueryWrapper<Paper> wrapper=new LambdaQueryWrapper<>();

        List<Paper> papers = paperMapper.selectList(null);
        Integer num = paperMapper.selectCount(null);
        Pages page =new Pages(papers,num);

        return page;
    }

    @Override
    public void addPaper(Paper paper) {
        paperMapper.insert(paper);
    }

    @Override
    public Paper getPaperById(Integer id) {
        Paper paper=paperMapper.selectById(id);
        return paper;
    }

    @Override
    public void updatePaper(Paper paper) {
        paperMapper.updateById(paper);
    }

    @Override
    public void deletePaper(Integer id) {
        paperMapper.deleteById(id);
    }

    @Transactional
    @Override
    public String getSrcByID(Integer id) {
        LambdaQueryWrapper<Paper>wrapper=new LambdaQueryWrapper<>();
        wrapper.select(Paper::getSrc).eq(Paper::getPaperID,id);
        Paper paper = paperMapper.selectOne(wrapper);

        return paper.getSrc();
    }
    //记录下载记录

    @Override
    public void countDownload(Integer id) {
        paperMapper.countDownload(id);

    }

    @Override
    public Integer getCPaper() {
        LambdaQueryWrapper<Paper>wrapper=new LambdaQueryWrapper<>();
        wrapper.le(Paper::getScore,60).gt(Paper::getScore,85);
        Integer CPaper = paperMapper.selectCount(wrapper);

        return CPaper ;
    }

    @Override
    public Integer getPaperNum() {
        LambdaQueryWrapper<Paper>wrapper=new LambdaQueryWrapper<>();
        wrapper.select(Paper::getSrc);
        Integer paperNum = paperMapper.selectCount(wrapper);
        return paperNum;
    }

    @Override
    public Pages searchPaper(String title, String author, String teacher, Integer page) {
        Page<Paper> searchPage=new Page<>(page,10);
        LambdaQueryWrapper<Paper> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(title),Paper::getTitle,title)
                .eq(StringUtils.hasLength(author),Paper::getAuthor,author)
                .eq(StringUtils.hasLength(teacher),Paper::getAdvisor,teacher);
        //List<Paper> papers = paperMapper.selectList(wrapper);
        Page<Paper> paperPage = paperMapper.selectPage(searchPage, wrapper);
        List<Paper> papers=paperPage.getRecords();//当前页的用户信息
        Integer num = paperMapper.selectCount(wrapper);//总共根据条件能查出多少数据
        Pages pages =new Pages(papers,num);
        System.out.println(pages);
        return pages;
    }

    //根据uid查papers


    @Override
    public List<Paper> getUserByUid(String uid) {
        LambdaQueryWrapper<Paper> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Paper::getUid,uid);
        List<Paper> papers = paperMapper.selectList(wrapper);
        return papers;
    }


    @Override
    public void saveDownload(PaperDownload paperDownload) {
        paperDownloadMapper.insert(paperDownload);
    }

    @Override
    public List<PaperDownload> selectDownload(Integer id) {
        //List<PaperDownload> downloads = paperDownloadMapper.selectList(null);
        List<PaperDownload> downloads = paperDownloadMapper.getByPaperId(id);
        return downloads;
    }



}
