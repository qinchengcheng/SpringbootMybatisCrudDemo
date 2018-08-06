package com.giveu.service;

import com.giveu.entity.Person;

import java.util.List;

/**
 * Created by fox on 2018/7/27.
 */
public interface PersonService {
	List<Person> list();
	Integer add(Person person);
	Integer del(Integer id);
}
