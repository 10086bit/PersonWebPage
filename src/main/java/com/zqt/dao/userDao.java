package com.zqt.dao;

import com.zqt.domain.user.Page;
import com.zqt.domain.user.myFile;
import com.zqt.domain.user.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userDao {
    public int insterUser(user user);
    public user searchUserByname(user user);
    public user searchUserBynameAndpwd(user user);
    public List<user> selectAllUser(@Param("start") int start, @Param("count") int count);

    public int getTotalUser();
    public int modifyUser(user user);
    public user selectSignalUserById(int u_id);
    public  int deleteUser(int uid);
    public Integer searchUserById(int id);
    public  int setHeadId(myFile myFile);
}
