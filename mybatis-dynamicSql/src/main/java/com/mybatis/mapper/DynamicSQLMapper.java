package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
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

    /*级联查询*/
    Emp getEmpAndDeptByEid(@Param("EmpId") Integer EmpId);
    /**
     * 根据部门id查新部门以及部门中的员工信息
     *
     * @return
     */
    Dept getDeptEmpByDid(@Param("deptId") Integer deptId);

    /**
     * 分步查询部门和部门中的员工
     * @param deptId
     * @return
     */
    Dept getDeptByStep(@Param("deptId") Integer deptId);
    /**
     * 根据部门id查询员工信息
     * @param deptId
     * @return
     */
    List<Emp> getEmpListByDid(@Param("deptId") Integer deptId);
}


