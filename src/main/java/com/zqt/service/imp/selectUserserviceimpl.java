package com.zqt.service.imp;

import com.zqt.dao.userDao;
import com.zqt.domain.user.user;
import com.zqt.service.selectUserservice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class selectUserserviceimpl implements selectUserservice {
    @Resource
    private userDao userDao;
    @Override
    public int selectUserByName(user user) {

        return userDao.searchUserByname(user).getIsAdmin();
    }

    @Override
    public List<user> selectAllUser() {
        List<user> list=new ArrayList<user>();
        List<user> lists=userDao.selectAllUser();
      //  System.out.println(lists);
        for(user user1:lists){
            user usertrmp=new user(user1.getU_name(),user1.getU_id(),user1.getU_head());
          //  System.out.println("1");
          //
            list.add(usertrmp);
        }
       // System.out.println(list);
        return list;
    }

    @Override
    public user selectSignalUser(int id) {
      user user=  userDao.selectSignalUserById(id);
       // System.out.println(user);
       // System.out.println(id);
        return user;
    }

    @Override
    public int retrunUserAdmin(int id) {
        if (userDao.searchUserById(id)==null){
            return 0;
        }
        else{
            return userDao.searchUserById(id);
        }

    }
}
