package com.zqt.controller;

import com.zqt.domain.user.Page;
import com.zqt.domain.user.article;
import com.zqt.domain.user.user;
import com.zqt.service.articleManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class articleController {
    @Resource
    articleManageService ams;
    @RequestMapping("saveArticle")
    public ModelAndView saveArticleController(HttpServletRequest request, HttpSession session){
        ModelAndView mav=new ModelAndView();
        //System.out.println(request.getParameter("text")+request.getParameter("title"));
        article article=new article();
        article.setUid((int)session.getAttribute("uid"));
        article.setText(request.getParameter("text"));
        article.setTitle(request.getParameter("title"));
        if(ams.savearticle(article)==1){
            mav.addObject("tips","发表成功");
            mav.setViewName("common/result");
        }else {
            mav.addObject("tips","发表失败");
            mav.setViewName("common/result");
        }
        return mav;
    }
    @RequestMapping("showtexts")
    @ResponseBody
    public Map<String,article> showTexts(HttpServletRequest request, HttpSession session){
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
                page.setTotal(ams.getArticleAll());
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
            page.setTotal(ams.getArticleAll());
            session.setAttribute("start", start);

        }
        session.setAttribute("pre",0);
        // System.out.println("首次查询");
        ams.searchAlltext((int)session.getAttribute("uid"),start,count);
        return ams.searchAlltext((int)session.getAttribute("uid"),start,count);

    }
}
