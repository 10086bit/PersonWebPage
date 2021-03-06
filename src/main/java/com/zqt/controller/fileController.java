package com.zqt.controller;

import com.zqt.domain.user.myFile;
import com.zqt.service.fileManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class fileController {

    @Resource
    fileManageService fms;
    @RequestMapping("uploadHeadFile")
    public ModelAndView uploadHeadFile(HttpServletRequest request,HttpSession session){
        ModelAndView mav=new ModelAndView();
        String attribute=(String) request.getAttribute("fatt");
        MultipartFile file=(MultipartFile)request.getAttribute("file");
        if (!file.isEmpty()){
           // String rootPath ="E:\\IdeaProject\\PersonWebPage\\upload";
            String rootPath =session.getServletContext().getRealPath("/upload");
            //System.out.println(request.getServletContext().getRealPath("/upfile"));
            //System.out.println(session.getServletContext().getRealPath("/upfile"));
            File dir = new File(rootPath);
            if (!dir.exists()){
                dir.mkdirs();
            }
            String newfilename= UUID.randomUUID()+"_"+file.getOriginalFilename();
            try {
                File fileup=new File(dir,newfilename);
                //System.out.println(fileup.getPath());
                myFile file1=new myFile();

                file1.setUid((int)session.getAttribute("uid"));
                file1.setFattribute(attribute);
               // file1.setFaddress(fileup.getPath());
                file1.setFaddress("/img/"+newfilename);
                file1.setFid(fms.searchfid(file1));
                //在上传头像之前先检查之前是否有头像并删除


                //System.out.println(strArr.length);
                if(fms.searchfaddress(file1)!=null){
                    String oldfilepath=fms.searchfaddress(file1);
                    String[] strArr=oldfilepath.split("/");
                    File oldfile=new File(rootPath+"\\"+strArr[2]);
                    System.out.println(rootPath+strArr[2]);
                    oldfile.delete();
                }
               // System.out.println(oldfilepath);

              //  System.out.println(file1.getFid()+file1.getUid()+file1.getFattribute()+file1.getFaddress());
                fms.upDateHead(file1);
                file.transferTo(fileup);
            } catch (IOException e) {
                mav.addObject("msg","error");
                mav.setViewName("common/Center");
                e.printStackTrace();
                return mav;
            }
            mav.addObject("msg","头像上传成功");
            mav.setViewName("common/Center");
            return mav;

        }else {
            mav.addObject("msg","空文件");
            mav.setViewName("common/Center");
            return mav;
        }

    }

}
