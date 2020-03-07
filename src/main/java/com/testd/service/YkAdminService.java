package com.testd.service;

import com.testd.pojo.DGytop;
import com.testd.pojo.YkAdmin;
import org.springframework.format.annotation.DateTimeFormat;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface YkAdminService {

    //Admin登录
    YkAdmin adminlogin(String userName, String password);

    //每次登录获取 （修改）当前时间和IP
    void updateYkAdmin(Integer userId, Date lastlogin, String ip);

    List<DGytop> Select();
}
