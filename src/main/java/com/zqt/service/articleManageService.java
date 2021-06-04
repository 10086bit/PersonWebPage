package com.zqt.service;

import com.zqt.domain.user.article;

import java.util.List;
import java.util.Map;

public interface articleManageService {
    public int savearticle(article article);
    public Map<String,article> searchAlltext(int uid, int start, int count);
    public int getArticleAll();
}
