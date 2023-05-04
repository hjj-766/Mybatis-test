package com.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {

    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        /*开启分页功能*/
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> list = mapper.selectByExample(null);
        System.out.println(page);



    }
}
