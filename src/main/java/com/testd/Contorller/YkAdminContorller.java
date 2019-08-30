package com.testd.Contorller;

import com.testd.pojo.YkAdmin;
import com.testd.service.YkAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class YkAdminContorller {
    @Autowired
    private YkAdminService ykAdminService;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("/login")
    public String ykAdminLogin(String userName, String password) {

        try {
            YkAdmin y = ykAdminService.adminlogin(userName, password);
            if (y != null) {
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

