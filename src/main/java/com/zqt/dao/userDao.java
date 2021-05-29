package com.zqt.dao;

import com.zqt.domain.user.user;

import java.util.List;

public interface userDao {
    public int insterUser(user user);
    public user searchUserByname(user user);
    public user searchUserBynameAndpwd(user user);
    public List<user> selectAllUser();
    public int modifyUser(user user);
    public user selectSignalUserById(int u_id);
    public  int deleteUser(int uid);
    public Integer searchUserById(int id);
}
