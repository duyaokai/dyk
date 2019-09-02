package com.testd.mapper;

import com.testd.pojo.YkAdmin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.util.Date;

@Repository
@Mapper
public interface YkAdminMaper {




    //登录验证  -------这里就不用--比较讨厌 --XMl 文件了直接用   注解方式   yk_admin
    @Select("select * from yk_admin where user_name=#{userName} and password=#{passWord}")
    @Results({
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "emali",property = "emali"),
            @Result(column = "password",property = "passWord"),
            @Result(column = "add_time",property = "addTime"),
            @Result(column = "last_login",property = "lastLogin"),
            @Result(column = "last_ip",property = "lastIp"),
    })
    YkAdmin  adminlogin(@Param("userName") String userName,
                        @Param("passWord") String passWord);


    //修改 admin 的每次登录获取 IP 和时间的  yk_admin
    @Update("update yk_admin set last_login=#{lastlogin},last_ip=#{ip} where user_id=#{userId}")
    @Results({
            @Result(id = true,column = "user_id",property = "userId"),
            @Result(column = "last_login",property = "lastLogin"),
            @Result(column = "last_ip",property = "lastIp"),
    })
    void updateYkAdmin(@Param("userId")Integer userId,
                       @Param("lastlogin") Date lastlogin,
                       @Param("ip") String ip);

}
