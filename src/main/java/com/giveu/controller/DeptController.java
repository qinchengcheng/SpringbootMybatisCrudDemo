package com.giveu.controller;

import com.giveu.entity.Dept;
import com.giveu.entity.Person;
import com.giveu.responEntity.ResponPerson;
import com.giveu.service.DeptService;
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
@RequestMapping(value = "dept")
@CrossOrigin
public class DeptController {

    @Autowired
    DeptService deptServiceImpl;

    @RequestMapping(value = "/list")
    List<Dept> list() {
        return deptServiceImpl.list();
    }

    @RequestMapping(value = "/detail")
    Dept getOne(Integer deptNo) {
        return deptServiceImpl.getDeptById(deptNo);
    }
}
