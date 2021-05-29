package com.zqt.service.imp;

import com.zqt.dao.userDao;
import com.zqt.domain.user.user;
import com.zqt.service.userIsEmptyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class userIsEmptyServiceimpl implements userIsEmptyService {
    @Resource
    private userDao userDao;
    @Override
    public boolean isEmpty(user user) {
        if ( userDao.searchUserByname(user)==null){

            return false;
        }else {
            return true;
        }
    }

    @Override
    public int isAdmin(user user) {
        int flag=-1;

     //   System.out.println(userDao.searchUserBynameAndpwd(user));
        if(userDao.searchUserBynameAndpwd(user)!=null) {
           user user1= userDao.searchUserBynameAndpwd(user);
            flag= user1.getIsAdmin();
        }
      //  System.out.println(flag);
        return  flag;
    }
}
