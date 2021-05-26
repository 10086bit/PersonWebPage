package com.zqt.controller;

import com.zqt.domain.user.user;
import com.zqt.service.imp.userRegisterServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller
public class userLoginAndregisterController {
    @Resource
    private userRegisterServiceimpl ursi;
    @RequestMapping("registerUer")
    public ModelAndView registerUer(user user, String code, HttpServletRequest req){
        ModelAndView mav=new ModelAndView();
        String tips="";
        String attribute = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        if(code.equals(attribute)){
            //System.out.println(code+attribute);
            tips="验证码错误";
            mav.addObject("tips",tips);
            mav.setViewName("forward:/common/register.jsp");
        }else {
            boolean flag=ursi.userRegister(user);
            if(!flag){
                tips="注册失败";
                mav.addObject("tips",tips);
                mav.setViewName("forward:/common/result.jsp");
            }else {
                tips="注册成功";
                mav.addObject("tips",tips);
                mav.setViewName("forward:/common/result.jsp");
            }
        }
        return mav;
    }

}

