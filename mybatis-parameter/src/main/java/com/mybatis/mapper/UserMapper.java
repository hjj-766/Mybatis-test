package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    /*根据用户名查询用户*/

    User getUerByUsername(@Param("username") String username);

    /*验证登录*/
    User checklogin(String username,String password);
    User checkloginbymap(Map<String,Object> map);

    void  insertUser(User user);

    User checkloginByParam(@Param("username") String username, @Param("password") String password);
}
