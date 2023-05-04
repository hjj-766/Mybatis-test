package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /*通过ID查询用户*/
    User getUserById(@Param("id") Integer id);


    List<User> getAllUser();
    /**
     * 查询用户的总记录数
     * @return
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如： java.lang.Integer-->int|integer
     * 例如： int-->_int|_integer
     * 例如： Map-->map,List-->list
     */
    Integer getCount();
    /**
     * 根据用户id查询用户信息为map集合
     *
     * @return
     */
    Map<String, Object> getUserToMap(Integer id);

    //List<Map<String, Object>> getUserToMapByAll();

    @MapKey("id")
    Map<String, Object> getUserToMapByAll();
}
