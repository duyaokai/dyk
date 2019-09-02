package com.testd.service.impl;

import com.testd.mapper.YkAdminMaper;
import com.testd.pojo.YkAdmin;
import com.testd.service.YkAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.Date;

@Service
public class YkAdminImpl implements YkAdminService {
    @Autowired
    private YkAdminMaper ykAdminMaper;


    //登录验证
    @Override
    public YkAdmin adminlogin(String userName, String password) {
        return ykAdminMaper.adminlogin(userName,password);
    }

    @Override
    public void updateYkAdmin(Integer userId, Date lastlogin, String ip) {
        ykAdminMaper.updateYkAdmin(userId,lastlogin,ip);
    }


}
