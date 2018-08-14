package com.giveu.dao;

import com.giveu.entity.Person;
import com.giveu.responEntity.ResponPerson;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Person 数据操作类
 * Created by fox on 2018/7/27.
 */
public interface PersonDAO {

	@Select("select p.*,d.dept_name from person p left join dept d on p.dept_no=d.dept_no where p.id = #{id}")
	ResponPerson getPersonById(@Param(value="id") Integer id);

	@Select("select p.*,d.dept_name from person p left join dept d on p.dept_no=d.dept_no order by p.person_create_time desc")
	List<ResponPerson> list();

	@Insert("insert into person(person_name, person_phone, person_email, person_sex, person_qq, person_desc,dept_no) value(#{personName}, #{personPhone}, #{personEmail}, #{personSex}, #{personQq}, #{personDesc},#{deptNo})")
	Integer add(Person person);

	@Delete("delete from person where id = #{id}")
	Integer del(@Param(value = "id") Integer id);

	@Update("update person set person_name=#{personName}, person_phone=#{personPhone}, person_email=#{personEmail}, person_sex=#{personSex}, person_qq=#{personQq}, person_desc=#{personDesc},dept_no=#{deptNo} where id = #{id}")
	Integer update(Person person);
}
