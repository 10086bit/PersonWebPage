package com.zqt.controller;

import com.zqt.service.selectUserservice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

    @RequestMapping("usermanage")
    public String toUserManage(){
        return "admin/usermanage";
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
