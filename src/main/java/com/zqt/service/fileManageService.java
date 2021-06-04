package com.zqt.service;

import com.zqt.domain.user.myFile;

public interface fileManageService {
    public boolean uploadFile(myFile myFile);
    public boolean upDateHead(myFile myFile);
    public  int searchfid(myFile myFile);
    public  String searchfaddress(myFile myFile);
    public int deleteHeadFile(int uid,String rootPath);
}
