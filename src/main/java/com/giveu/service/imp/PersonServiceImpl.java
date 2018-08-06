package com.giveu.service.imp;

import com.giveu.dao.PersonDAO;
import com.giveu.entity.Person;
import com.giveu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fox on 2018/7/27.
 */
@Service
public class PersonServiceImpl implements PersonService {

	@SuppressWarnings("all")
	@Autowired
	PersonDAO personDAO;

	@Override
	public List<Person> list() {
		return personDAO.list();
	}

	@Override
	public Integer add(Person person) {
		return personDAO.add(person);
	}

	@Override
	public Integer del(Integer id) {
		return personDAO.del(id);
	}
}
