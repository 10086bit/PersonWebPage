package com.zqt.service;

import com.zqt.domain.user.user;
import org.springframework.stereotype.Service;

import java.util.List;

public interface selectUserservice {

    public int selectUserByName(user user);
    public List<user> selectAllUser();
    public user selectSignalUser(int id);
    public int retrunUserAdmin(int id);
}
