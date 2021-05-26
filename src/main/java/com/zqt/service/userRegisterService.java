package com.zqt.service;

import com.zqt.domain.user.user;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface userRegisterService {
    public boolean userRegister( user user) throws IOException;
}
