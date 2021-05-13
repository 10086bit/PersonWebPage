package com.zqt.serviceimpl;

import com.zqt.dao.adminDao;
import com.zqt.domain.root.admin;
import com.zqt.service.selectAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class selectAdminimpl implements selectAdmin {
    @Autowired
    private adminDao adminDao;
    @Override
    public int isExit(admin admin) {
        adminDao.selectUser(admin);
        return 0;
    }
}
