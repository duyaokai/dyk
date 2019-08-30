package com.testd.service.impl;

import com.testd.mapper.YkAdminMaper;
import com.testd.pojo.YkAdmin;
import com.testd.service.YkAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YkAdminImpl implements YkAdminService {
    @Autowired
    private YkAdminMaper ykAdminMaper;

    @Override
    public YkAdmin adminlogin(String userName, String password) {
        return ykAdminMaper.adminlogin(userName,password);
    }
}
