package com.zqt.service.imp;

import com.zqt.dao.fileDao;
import com.zqt.dao.userDao;
import com.zqt.domain.user.myFile;
import com.zqt.domain.user.user;
import com.zqt.service.userRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class userRegisterServiceimpl implements userRegisterService {
    @Resource
    private userDao userDao;
    @Resource
    private fileDao fileDao;
    @Override
    public boolean userRegister(user user) {
      //  System.out.println(user.getU_name()+user.getU_passwd());
        int result=userDao.insterUser(user);
        //注册时会在头像数据库中分配一个空的位置
        user user1=userDao.searchUserBynameAndpwd(user);
        myFile myFile = new myFile();
        myFile.setUid(user1.getU_id());
        myFile.setFattribute("head");
        fileDao.uploadFile(myFile);

        //然后将该位置的fid配置到user的head属性上
        myFile.setFid(fileDao.selectFileByUidAndFa(myFile));
        userDao.setHeadId(myFile);
        if(result==0){
            return false;
        }else {
            return true;
        }

    }
}
