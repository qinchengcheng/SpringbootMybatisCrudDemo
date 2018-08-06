package com.giveu.dao;

import com.giveu.entity.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Person 数据操作类
 * Created by fox on 2018/7/27.
 */
public interface PersonDAO {

	@Select("select * from person where id = #{id}")
	Person getPersonById(@Param(value="id") Integer id);

	@Select("select * from person")
	List<Person> list();

	@Insert("insert into person(person_name, person_phone, person_email, person_sex, person_qq, person_desc) value(#{personName}, #{personPhone}, #{personEmail}, #{personSex}, #{personQq}, #{personDesc})")
	Integer add(Person person);

	@Delete("delete from person where id = #{id}")
	Integer del(@Param(value = "id") Integer id);

}
