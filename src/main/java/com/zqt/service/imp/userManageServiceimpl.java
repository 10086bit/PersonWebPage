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
        int i =userDao.modifyUser(user);

        return i;
    }

    @Override
    public int deleUser(int uid) {
        int i =userDao.deleteUser(uid);

        return i;
    }
}
