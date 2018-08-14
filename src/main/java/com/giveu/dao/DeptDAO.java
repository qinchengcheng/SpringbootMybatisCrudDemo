package com.giveu.dao;

import com.giveu.entity.Dept;
import com.giveu.entity.Person;
import com.giveu.responEntity.ResponPerson;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Person 数据操作类
 * Created by fox on 2018/7/27.
 */
public interface DeptDAO {

    @Select("select * from  dept  where dept_no = #{deptNo}")
    Dept getDeptById(@Param(value="id") Integer deptNo);

    @Select("select * from dept")
    List<Dept> list();
}
