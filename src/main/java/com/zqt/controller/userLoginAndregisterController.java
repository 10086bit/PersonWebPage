package com.zqt.controller;

import com.zqt.domain.user.user;
import com.zqt.service.imp.userRegisterServiceimpl;
import com.zqt.service.selectUserservice;
import com.zqt.service.userIsEmptyService;
import com.zqt.service.userRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller
public class userLoginAndregisterController {
    @Resource
    private userRegisterServiceimpl ursi;
    @Resource
    private userIsEmptyService uies;
    @Resource
    private selectUserservice sus;
    @RequestMapping("registerUer")
    public ModelAndView registerUer(user user, String code, HttpServletRequest req){
        ModelAndView mav=new ModelAndView();
        String tips="";
        String attribute = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        if(!code.equals(attribute)){
            //System.out.println(code+attribute);
            tips="验证码错误";
            mav.addObject("tips",tips);
            mav.setViewName("common/register");
        }else if (uies.isEmpty(user)){
            tips="该用户名已经备注过";
            mav.addObject("tips",tips);
            mav.setViewName("common/register");
        }else {
            boolean flag=ursi.userRegister(user);
            if(!flag){
                tips="注册失败";
                mav.addObject("tips",tips);
                mav.setViewName("common/result");
            }else {
                tips="注册成功";
                mav.addObject("tips",tips);
                mav.setViewName("common/result");
            }
        }
        return mav;
    }
    @RequestMapping("loginUsercontroller")
    public ModelAndView LoginUer(user user , HttpSession Session){
        ModelAndView mav=new ModelAndView();
        String tips="";
        int flag=uies.isAdmin(user);
        if (flag>=0){
            tips="登入成功";
            mav.addObject("tips",tips);
            Session.setAttribute("uid",sus.selectUserByName(user));
            if (flag==1){
                mav.setViewName("admin/adminCenter");
            }else if (flag==0){
                mav.setViewName("user/userCenter");
            }
        }else {
            tips="登入失败";
            mav.addObject("tips",tips);
            mav.setViewName("common/result");
        }
        return mav;
    }
    @RequestMapping("outAdminUser")
    public String layoutAdminUser(HttpSession session){
        session.removeAttribute("uid");
        return "forward:index.jsp";
    }
}

