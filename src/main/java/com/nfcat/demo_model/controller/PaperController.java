package com.nfcat.demo_model.controller;

import com.nfcat.demo_model.pojo.*;
import com.nfcat.demo_model.service.PaperService;

import org.apache.poi.POIReadOnlyDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.html.HTMLCollection;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    //测试用
    @GetMapping("getCookie")
    @ResponseBody
    public String getCookie(HttpServletResponse response){
        Cookie cookie=new Cookie("username","987987987");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        return "set cookie success!";
    }
    //测试用注解
    @ResponseBody
    @GetMapping("/paper")
    public Pages getPaper(Model model){
        List<Paper> papers= paperService.getAllPaper();
        Pages page = paperService.getPaperPage();
        model.addAttribute("papers",papers);
        return page;
        //return "papers";
    }

    @RequestMapping("/papers/add")
    public String toAdd(){
        return "paper_add";
    }
    //添加paper
    @PostMapping("/paper")
    public String addPaper(Paper paper,
                           @RequestParam("file") MultipartFile multipartFile,
                           HttpSession httpSession) throws IOException {
        ServletContext servletContext = httpSession.getServletContext();
        String filename = multipartFile.getOriginalFilename();
        String paperPath = servletContext.getRealPath("paper");
        File file=new File(paperPath);
        if (!file.exists()){
            file.mkdir();
        }

        //src
        String finalPath =paperPath+File.separator+filename;
        multipartFile.transferTo(new File(finalPath));
        paper.setSrc(finalPath);

        paperService.addPaper(paper);
        return "redirect:/paper";

    }
    //点击修改按钮跳转到用户的论文
    @GetMapping("/paper/update")
    //测试用注解，
    @ResponseBody
    public List<Paper> toUpdate(Model model,
                           @CookieValue("username")String uid){
        System.out.println("cookie:"+uid);
        List<Paper> papers= paperService.getUserByUid(uid);
        model.addAttribute("papers",papers);
        return papers;
    }

    //按照id查询
    @GetMapping("/paper/{id}")
    public String getPaperById(@PathVariable("id") Integer id,
                               Model model){
        Paper paper= paperService.getPaperById(id);
        model.addAttribute("paper",paper);

            return "paper_update";

    }
    //修改paper
    @PutMapping("/paper")
    public String updatePaper(@RequestBody Paper paper
                              //@RequestParam(required = false,value = "file") MultipartFile multipartFile,
                           ) throws IOException {
        System.out.println("修改论文请求:"+paper);
        paperService.updatePaper(paper);
        return "sueecss";
    }


    @PostMapping("/paper/updata")
    public String updatePapera(@RequestBody Paper paper){
        System.out.println("修改论文请求:"+paper);
       paperService.updatePaper(paper);
       return "asd";
    }


    //删除paper
    @PostMapping("/paper/{id}")
    @ResponseBody
    public String deletePaper(@PathVariable("id") Integer id){
        paperService.deletePaper(id);
        return "success";
    }

    @GetMapping("/readonline/{id}")
    public String  test(@PathVariable("id") Integer id,Model model) throws IOException{
        String src = "./thesis/"+paperService.getSrcByID(id);
        System.out.println("aaaa");
        File file=new File(src);
        System.out.println(file.exists()+"文件名"+file.getName());

        FileInputStream fileInputStream = new FileInputStream(file);

 /*   byte[] bytes=new byte[fileInputStream.available()];
    int length=fileInputStream.read(bytes);
    String s= new String(bytes,0,length ) ;
    System.out.println(s);*/
        XWPFDocument xwpfDocument=new XWPFDocument(fileInputStream);
        XWPFWordExtractor xwpfWordExtractor=new XWPFWordExtractor(xwpfDocument);
        String text = xwpfWordExtractor.getText();
        System.out.println(text);
        model.addAttribute("text",text);
        return "word";
    }


    //在线阅读
    @GetMapping("/read/{id}")
    @ResponseBody
    public String readPaper(@PathVariable("id")Integer id,Model model,HttpServletResponse resp) throws Exception {

        String src = "./thesis/"+paperService.getSrcByID(id);
        //String src = "./thesis/12345601/abc.txt";
        String fileContent = "";
        if (src != null) {
            fileContent = readFileContent(src);
           // model.addAttribute("fileContent", fileContent);
        }
        byte[] b = fileContent.getBytes(StandardCharsets.UTF_8);
        String mesg = new String(b,"utf-8");
        System.out.println(mesg);

        return mesg;
    }
    private String readFileContent(String filePath){




        try {
            StringBuilder content = new StringBuilder();
            int length=0;
            String name = new File(filePath).getName();
//创建输入流
            InputStream is = new FileInputStream(filePath);
//创建字节数组
            byte[] bytes = new byte[is.available()];
            while ((length = is.read(bytes))!= -1) {
                content.append(new String(bytes,0,length));
            }
            //is.read(bytes);
            return content.toString();
        }catch (Exception e){

        }
return null;

    }

    //下载
    @RequestMapping("/download/d")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session,
                                                     @RequestParam("id") Integer id,
                                                     @CookieValue("username") String username) throws
            IOException {
        /*
         *查看论文下载用户与时间
         * 1.获取sessionId(获取下载的用户)
         * 2.下载数量+1
         * 3.获取下载时间
         * 4.在Paper表中添加数据
         *
         *
         * */
        //Integer id = paper.getPaperID();

        //获取当前时间作为下载时间
        LocalDateTime downloadTime=LocalDateTime.now();

        //String sessionId = session.getId();

        //记录下载次数
        paperService.countDownload(id);

        //获取下载用户 username


        //将信息加入userdownload表;username,time,paperID
        PaperDownload paperDownload=new PaperDownload(null,id,username,downloadTime);
        // paperService.saveDownload(username,downloadTime,id);
        paperService.saveDownload(paperDownload);

/**
 * 下载
 * */

//获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器文件
        String src = paperService.getSrcByID(id);
       String finalsrc="./thesis/"+src;
        //String finalsrc="./thesis/12345601/abc.txt";
        String name = new File(finalsrc).getName();
//创建输入流
        InputStream is = new FileInputStream(finalsrc);
//创建字节数组
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
//创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
//设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename="+name);
        //headers.add("Content-Type", "application/octet-stream;charset=UTF-8");
        headers.add("Content-Type", "application/msword;charset=UTF-8");
        headers.add("Content-Length", String.valueOf(bytes.length));
//设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
//创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
//关闭输入流
        is.close();
        return responseEntity;
    }

    @GetMapping("/download")
    @ResponseBody
    public List<PaperDownload>  selectDownloadMsg(@RequestParam Integer paperID){

        System.out.println("paperID:"+paperID);
        //Integer paperID = paper.getPaperID();


        List<PaperDownload>downloads= paperService.selectDownload(paperID);
        return downloads;
    }
    //上传文件
    @RequestMapping("/paper/upload/")
    public String testUpload(MultipartFile multipartFile,
                             HttpSession httpSession) throws IOException {
        ServletContext servletContext = httpSession.getServletContext();
        String filename = multipartFile.getOriginalFilename();
        String photoPath = servletContext.getRealPath("paper");
        File file=new File(photoPath);
        if (!file.exists()){
            file.mkdir();
        }

        //src
        String finalPath =photoPath+File.separator+filename;

        multipartFile.transferTo(new File(finalPath));
        return "success";


    }
    @RequestMapping("/paper/info")
    public String paperInfo(Model model){
        //todo:获取及格的（60-85）的论文数量，优秀 的论文数量>=85,论文总数
        Integer CPaper=paperService.getCPaper();
        Integer PaperNum= paperService.getPaperNum();
        model.addAttribute("CPaper",CPaper);

        return "PaperInfo";
    }

    @ResponseBody
    @PostMapping("/paper/search")
    public Pages searchPaper(@RequestBody Paper paper){

        Pages pages;

        if (paper.getPage()==null){
            pages = paperService.searchPaper(paper.getTitle(), paper.getAuthor(),paper.getAdvisor(), 0);
        }else {
            pages = paperService.searchPaper(paper.getTitle(), paper.getAuthor(),paper.getAdvisor(), paper.getPage());
        }

        //List<Paper> papers= paperService.searchPaper(title,author,teacher,page);
        return pages;

    }


    /**
     *
     * 下载次数排行*/
    @GetMapping("/rank")
    @ResponseBody
    public Pages rank(@RequestParam(required = false)Integer page){
        Pages pages;
        if (page==null){
            pages= paperService.rankByDownload(0);
        }
        else { int num=(page-1)*10;
            pages= paperService.rankByDownload(num);
        }

        return pages;
    }

    @GetMapping("/school")
    @ResponseBody
    public TongJi searchBySchool(){

        TongJi tongJi = paperService.tongJi();
        return tongJi;

    }

}
