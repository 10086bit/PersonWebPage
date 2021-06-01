package com.zqt.controller;

import com.zqt.service.selectUserservice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class pageVisitController {
    @Resource
    private selectUserservice sus;
    @RequestMapping("login")
    public String loginPage(){
        return "forward:/common/login.jsp";
    }

    @RequestMapping("register")
    public String registerPage(){
        return "forward:/common/register.jsp";
    }

    @RequestMapping("pageChange")
    public String pageChange(String pre,HttpSession session){
       // System.out.println(pre);
        session.setAttribute("pre",Integer.parseInt(pre));

        return "admin/usermanage";
    }
    @RequestMapping("toUpHead")
    public String upHead(MultipartFile file, HttpServletRequest request){
        request.setAttribute("fatt","head");
        request.setAttribute("file",file);
        return "forward:uploadFile";
    }
    @RequestMapping("usermanage")
    public String toUserManage(){
        return "admin/usermanage";
    }
    @RequestMapping("toCenter")
    public String toCenter(){
        return "forward:/common/Center.jsp";
    }
    @RequestMapping("toModUser")
    public String toModUser(int uid , HttpSession session){
        session.setAttribute("suid",uid);
        return "admin/modifyUser";
    }

    @RequestMapping("tologUser")
    public String tologUser(HttpSession session){
       // System.out.println("tz");
        int id=(int)session.getAttribute("uid");
        int i=sus.retrunUserAdmin(id);
        if(i==1){
            return "admin/adminCenter";
        }else {
            return "user/userCenter";
        }

    }

}
