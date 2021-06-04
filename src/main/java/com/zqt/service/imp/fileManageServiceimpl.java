package com.zqt.service.imp;

import com.zqt.dao.fileDao;
import com.zqt.domain.user.myFile;
import com.zqt.service.fileManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

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

    @Override
    public int deleteHeadFile(int uid,String rootPath) {
        //先查询到用户的fid
        myFile myFile=new myFile();
        myFile.setFattribute("head");
        myFile.setUid(uid);
        int fid=fileDao.selectFileByUidAndFa(myFile);
        myFile.setFid(fid);
        //然后查询有无头像文件
        if (searchfaddress(myFile)==null){
            return 1;
        }else {
            String oldfilepath=searchfaddress(myFile);
            String[] strArr=oldfilepath.split("/");
            File oldfile=new File(rootPath+"\\"+strArr[2]);
            fileDao.deletefile(myFile.getFid());
            if (oldfile.delete()){
                return 1;
            }else {
                return 0;
            }

        }

    }

}
