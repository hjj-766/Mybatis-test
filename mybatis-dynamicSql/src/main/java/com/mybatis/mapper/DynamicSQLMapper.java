package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /*根据条件查询员工信息*/
    List<Emp> getEmpByCondition(Emp emp);
    /*批量添加员工信息*/
    void inserMoreEmp(@Param("emps") List<Emp> emps);

    /*批量删除员工信息*/
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}


