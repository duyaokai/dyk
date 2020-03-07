package com.testd.Contorller;

import com.alibaba.fastjson.JSONArray;
import com.testd.pojo.DGytop;
import com.testd.pojo.YkAdmin;
import com.testd.service.YkAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;


@Controller
public class YkAdminContorller {
    @Autowired
    private YkAdminService ykAdminService;
    //导航页面
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String login(){
        return "login/login";
    }


    //登录 以及修改 IP
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
                return "home/home";
            } else {

                return "login/login_qian";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//(value = "/tubiao",method = RequestMethod.GET)
    @RequestMapping("tubiao")
    @ResponseBody
    public JSONObject TB(){

        JSONObject json =new JSONObject();
        json.put("data", ykAdminService.Select());
        return json;
    }



}

