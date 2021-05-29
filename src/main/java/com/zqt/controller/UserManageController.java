package com.zqt.controller;

import com.zqt.domain.user.user;
import com.zqt.service.selectUserservice;
import com.zqt.service.userManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserManageController {
    @Resource
    private selectUserservice sus;
    @Resource
    private userManageService ums;
    @RequestMapping("showuser")
    @ResponseBody
    public List<user> showStudent(){

        return sus.selectAllUser();
    }
    @RequestMapping("showsignaluser")
    @ResponseBody
    public user showUser(HttpSession session){
        int id=(int)session.getAttribute("suid");
        //session.removeAttribute("suid");
        return sus.selectSignalUser(id);
    }
    @RequestMapping("modUser")
    public ModelAndView modifyUser(int uid,user user ){
      //  System.out.println(uid);
       //System.out.println(user);
        ModelAndView mav=new ModelAndView();
        int flag=ums.modifyUser(uid,user);
        if (flag==0){
            mav.addObject("msg","修改失败");
        }
        else {
            mav.addObject("msg","修改成功");
        }
        mav.setViewName("admin/modifyUser");
        return mav;
    }
    @RequestMapping("delUser")
    public ModelAndView DelUser(int uid,HttpSession session){
        ModelAndView mav=new ModelAndView();
        int flag=-1;

        if ((int)session.getAttribute("suid")==1){
            System.out.println((int)session.getAttribute("suid"));
            mav.addObject("delmsg","你无法删除root成员");
            mav.setViewName("admin/modifyUser");
        }else {
           flag =ums.deleUser(uid);

            if (flag==0){
                mav.addObject("delmsg","删除失败");
                mav.setViewName("admin/modifyUser");
            }
            else {
                session.removeAttribute("suid");

                mav.setViewName("admin/usermanage");
            }
        }


        return mav;
    }
}
