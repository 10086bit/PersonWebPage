package com.zqt.service.imp;

import com.zqt.dao.userDao;
import com.zqt.domain.user.user;
import com.zqt.service.userManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class userManageServiceimpl implements userManageService {
    @Resource
    private userDao userDao;
    @Override
    public int modifyUser(int uid, user user) {
        user.setU_id(uid);
        if (user.getU_name().equals("")&&!user.getU_passwd().equals("")){
            user user1=userDao.selectSignalUserById(uid);
            String name=user1.getU_name();
            user.setU_name(name);
        }else if (user.getU_passwd().equals("")&&!user.getU_name().equals("")){
            user user1=userDao.selectSignalUserById(uid);
            String passwd=user1.getU_passwd();
            user.setU_passwd(passwd);
        }else {
            user user1=userDao.selectSignalUserById(uid);
            String passwd=user1.getU_passwd();
            user.setU_passwd(passwd);
            String name=user1.getU_name();
            user.setU_name(name);
        }
        int i =userDao.modifyUser(user);

        return i;
    }

    @Override
    public int deleUser(int uid) {
        int i =userDao.deleteUser(uid);

        return i;
    }
}
