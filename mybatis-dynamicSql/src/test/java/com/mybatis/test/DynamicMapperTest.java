package com.mybatis.test;

import com.mybatis.mapper.DynamicSQLMapper;
import com.mybatis.pojo.Dept;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,"",null,"女",null);
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        empByCondition.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{4,5};
        mapper.deleteMoreEmp(empIds);
        sqlSession.close();
    }
    @Test
    public void testgetEmpAndDeptByEid(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = mapper.getEmpAndDeptByEid(1);
        System.out.println(emp);
        sqlSession.close();
    }
    @Test
    public void testgetEmpAndDeptByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Dept dept = mapper.getDeptEmpByDid(2);
        System.out.println(dept);
        sqlSession.close();
    }
    @Test
    public void testgetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Dept dept = mapper.getDeptByStep(2);
        System.out.println(dept);
        sqlSession.close();
    }

}
