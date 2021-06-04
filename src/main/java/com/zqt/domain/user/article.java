package com.zqt.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class article {
    private String text;
    private int aid;
    private  int uid;
    private String title;
    private  String date;
    private user user;

}
