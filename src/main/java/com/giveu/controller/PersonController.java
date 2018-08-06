package com.giveu.controller;

import com.giveu.entity.Person;
import com.giveu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fox on 2018/7/27.
 */
@RestController
@RequestMapping(value = "person")
@CrossOrigin
public class PersonController {

	@Autowired
	PersonService personServiceImpl;

	@RequestMapping(value = "/list")
	List<Person> list() {
		return personServiceImpl.list();
	}

	@RequestMapping(value = "/add")
	Integer add(Person person) {
		return personServiceImpl.add(person);
	}

	@RequestMapping(value = "/del")
	Integer del(Integer id) {
		return personServiceImpl.del(id);
	}
}
