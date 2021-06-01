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
    private int u_head;

    public user(String u_name, int u_id, int u_head) {
        this.u_name = u_name;
        this.u_id = u_id;
        this.u_head = u_head;
    }
}
