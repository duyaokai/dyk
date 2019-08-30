package com.testd.mapper;

import com.testd.pojo.YkAdmin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface YkAdminMaper {

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

    @Update("update ")
    void updateYkAdmin(Integer userId);

}
