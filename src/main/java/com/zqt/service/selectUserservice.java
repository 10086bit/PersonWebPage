package com.zqt.service;

import com.zqt.domain.user.Page;
import com.zqt.domain.user.user;
import org.springframework.stereotype.Service;

import java.util.List;

public interface selectUserservice {

    public int selectUserByName(user user);
    public List<user> selectAllUser(int start,int count);
    public user selectSignalUser(int id);
    public int retrunUserAdmin(int id);
    public  int getUserTotal();
}
