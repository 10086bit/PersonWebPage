package com.zqt.dao;

import com.zqt.domain.user.article;

import java.util.List;

public interface articleDao {
    public int saveArticle(article article);
    public List<article> searchAllArticle(int uid, int start, int count);
    public int getTotalArticle();

}
