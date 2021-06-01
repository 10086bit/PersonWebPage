package com.zqt.service.imp;

import com.zqt.dao.fileDao;
import com.zqt.domain.user.myFile;
import com.zqt.service.fileManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class fileManageServiceimpl implements fileManageService {
    @Resource
    fileDao fileDao;

    @Override
    public boolean uploadFile(myFile myFile) {
        int i=fileDao.uploadFile(myFile);
        if (i>1){
            return true;
        }else {
            return false;
        }

    }
    public boolean upDateHead(myFile myFile) {
        int i=fileDao.upDateFile(myFile);
        if (i>1){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public int searchfid(myFile myFile) {

        return fileDao.selectFileByUidAndFa(myFile);
    }

    @Override
    public String searchfaddress(myFile myFile) {
        return fileDao.selectHeadFileByFid(myFile);
    }

}
