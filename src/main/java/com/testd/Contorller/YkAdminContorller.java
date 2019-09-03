package com.testd.Contorller;

import com.testd.pojo.YkAdmin;
import com.testd.service.YkAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;


@Controller
public class YkAdminContorller {
    @Autowired
    private YkAdminService ykAdminService;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String login(){
        return "login/login_qian";
    }

    @RequestMapping("/login")
    public String ykAdminLogin(String userName, String password) {

        try {
            YkAdmin y = ykAdminService.adminlogin(userName, password);
            if (y != null) {

                //获取登录时间
                Date lastlogin=new Date();
                SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(time.format(lastlogin));

                //InetAddress ip =InetAddress.getLocalHost();
                //获取IP
                String ip= String.valueOf(InetAddress.getLocalHost());

                ykAdminService.updateYkAdmin(y.getUserId(),lastlogin,ip);
                System.out.println();
                return "home/home";
            } else {

                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

