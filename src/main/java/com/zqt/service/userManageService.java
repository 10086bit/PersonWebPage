package com.zqt.service;

import com.zqt.domain.user.user;

public interface userManageService {
    public int modifyUser(int uid, user user);
    public int deleUser(int uid);
}
