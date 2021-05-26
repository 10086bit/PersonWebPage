package com.zqt.service;

import com.zqt.domain.user.user;

import java.io.IOException;

public interface userIsEmptyService {
    public boolean isEmpty( user user);
    public int  isAdmin(user user);
}
