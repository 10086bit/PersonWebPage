package com.zqt.service.imp;

import com.zqt.dao.articleDao;
import com.zqt.dao.userDao;
import com.zqt.domain.user.article;
import com.zqt.domain.user.user;
import com.zqt.service.articleManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class articleManageimpl implements articleManageService {
    @Resource
    articleDao articleDao;

    @Resource
    userDao userDao;
    @Override
    public int savearticle(article article) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        System.out.println(df.format(new Date()));
        String nowdate=df.format(new Date());
        article.setDate(nowdate);
        return  articleDao.saveArticle(article);

    }

    @Override
    public  Map<String,article> searchAlltext(int uid, int start, int count) {
        List<article> list;
        Map<String,article> articles=new HashMap<>();
        int u_id=uid;
        //user user=userDao.selectSignalUserById(u_id);
        list=articleDao.searchAllArticle(uid,start,count);
       /* for (article article:list){
            articles.put(user.getU_name(),article);
        }*/
        System.out.println(list);
        return articles;
    }

    @Override
    public int getArticleAll() {
        return articleDao.getTotalArticle();
    }

}
