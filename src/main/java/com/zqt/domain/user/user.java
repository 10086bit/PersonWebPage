package com.zqt.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    private int isAdmin;
    private String u_name;
    private  String u_passwd;
    private int u_id;
    private String u_head;
}
