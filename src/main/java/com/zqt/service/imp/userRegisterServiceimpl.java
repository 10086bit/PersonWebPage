package com.zqt.service.imp;

import com.zqt.dao.userDao;
import com.zqt.domain.user.user;
import com.zqt.service.userRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Service
public class userRegisterServiceimpl implements userRegisterService {
    @Resource
    private userDao userDao;
    @Override
    public boolean userRegister(user user) {
        System.out.println(user.getU_name()+user.getU_passwd());
        int result=userDao.insterUser(user);
        if(result==0){
            return false;
        }else {
            return true;
        }

    }
}
