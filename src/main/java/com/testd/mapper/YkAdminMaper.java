package com.testd.mapper;

import com.testd.pojo.DGytop;
import com.testd.pojo.YkAdmin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface YkAdminMaper {



    //  -------这里就不用- XMl 文件了直接用注解方式  别问我为啥 自己写任性
    //登录验证
    //  yk_admin
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

    @Select("select * from D_GYTOP")
    @Results({
            @Result(id = true,column = "ID",property = "id"),
            @Result(column = "times",property = "times"),
            @Result(column = "money",property = "money"),
            @Result(column = "shangzhang",property = "shangzhang"),
    })
    List<DGytop> Select();



}
