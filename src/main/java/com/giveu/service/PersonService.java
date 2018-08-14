package com.giveu.service;

import com.giveu.entity.Person;
import com.giveu.responEntity.ResponPerson;

import java.util.List;

/**
 * Created by fox on 2018/7/27.
 */
public interface PersonService {
	List<ResponPerson> list();
	Integer add(Person person);
	Integer del(Integer id);
	Integer update(Person person);
	ResponPerson getPerson(Integer id);
}
