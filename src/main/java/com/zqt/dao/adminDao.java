package com.zqt.dao;

import com.zqt.domain.root.admin;

public interface adminDao {
    public admin selectUser(admin admin);
    public boolean loginadmin(admin admin);
}
