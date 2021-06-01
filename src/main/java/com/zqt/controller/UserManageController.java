package com.zqt.controller;

import com.zqt.domain.user.Page;
import com.zqt.domain.user.myFile;
import com.zqt.domain.user.user;
import com.zqt.service.fileManageService;
import com.zqt.service.selectUserservice;
import com.zqt.service.userManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserManageController {
    @Resource
    private selectUserservice sus;
    @Resource
    private userManageService ums;
    @Resource
    private fileManageService fms;
    @RequestMapping("showuser")
    @ResponseBody
    public List<user> showStudent(HttpServletRequest request,HttpSession session){
        int start =0;
        int count =10;
        Page page;
        if (session.getAttribute("pre")!=null&&session.getAttribute("start")!=null) {
            //System.out.println((int) session.getAttribute("pre"));
            if ((int) session.getAttribute("pre") != 0) {
               // System.out.println("下一页查询" + session.getAttribute("pre"));
                int j = (int) session.getAttribute("start");
                int i = (int) session.getAttribute("pre");

                page = new Page(j, 10);
                page.setTotal(sus.getUserTotal());
                if (i > 0) {
                    //System.out.println(".............");
                    if (page.isHasNext()) {
                        //System.out.println("下一页查询");
                        j = j + count * i;
                        session.setAttribute("start", j);
                        start = j;
                    } else {
                        start = j;
                    }
                } else {
                    if (page.isHasPre()) {
                        //System.out.println("上一页查询");
                        j = j + count * i;
                       // System.out.println(j);
                        session.setAttribute("start", j);
                        start = j;
                    } else {
                        start = j;
                    }
                }
            }
        }else {
            //System.out.println("第一次查询");
            page = new Page(start, count);
            page.setTotal(sus.getUserTotal());
            session.setAttribute("start", start);

        }
        session.setAttribute("pre",0);
       // System.out.println("首次查询");
       return sus.selectAllUser(start, count);

    }
    @RequestMapping("showsignaluser")
    @ResponseBody
    public user showUser(HttpSession session){
        int id=(int)session.getAttribute("suid");
        //session.removeAttribute("suid");
        return sus.selectSignalUser(id);
    }

    @RequestMapping("showOwn")
    @ResponseBody
    public user showOwn(HttpSession session){
        int id=(int)session.getAttribute("uid");
        //session.removeAttribute("suid");
        return sus.selectSignalUser(id);
    }

    @RequestMapping("showOwnHead")
    @ResponseBody
    public myFile showOwnHead(HttpSession session){
        int id=(int)session.getAttribute("uid");
        //session.removeAttribute("suid");
        user user=sus.selectSignalUser(id);
        myFile myFile=new myFile();
        myFile.setFid(user.getU_head());
        String filepath=fms.searchfaddress(myFile);

       // System.out.println(user.getU_head()+fms.searchfaddress(myFile));
        myFile.setFaddress(fms.searchfaddress(myFile));
       return myFile;
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
