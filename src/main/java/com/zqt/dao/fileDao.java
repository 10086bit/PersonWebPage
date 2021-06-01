package com.zqt.dao;

import com.zqt.domain.user.myFile;

public interface fileDao {
    public int uploadFile(myFile myFile);
    public int upDateFile(myFile myFile);
    public int selectFileByUidAndFa(myFile myFile);
    public String selectHeadFileByFid(myFile myFile);
}
