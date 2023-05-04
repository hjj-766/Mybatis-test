package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParameterTest {

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUerByUsername("hjj");
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testcheklogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checklogin("hjj","543535");
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testchekloginbymap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","hjj");
        map.put("password","543535");
        User user = mapper.checkloginbymap(map);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testinseruser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User(null,"root","46456",45,"女","45sasad");
        mapper.insertUser(user1);
        sqlSession.close();
    }
    @Test
    public void testchekloginbyparam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkloginByParam("hjj","543535");
        System.out.println(user);
        sqlSession.close();
    }


}
