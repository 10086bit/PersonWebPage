package com.zqt.controller;

import com.zqt.domain.root.admin;
import com.zqt.service.imp.selectAdminimpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;

@Controller
public class loginadmin {
    @Resource
    private selectAdminimpl selectAdminimpl;
    @RequestMapping ("/loginadmin")
    public ModelAndView Loginadmin(admin admin){
        int flag=0;
        String tips="";
        ModelAndView mav=new ModelAndView();
        flag=selectAdminimpl.isExit(admin);
        if (flag==1){
            tips="登入成功";
            mav.addObject("tips",tips);
        }else{
            tips="登入失败，密码或者账号错误";
            mav.addObject("tips",tips);
        }
        mav.setViewName("result");
        return mav;
    }

}
