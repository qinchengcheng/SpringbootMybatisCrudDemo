package com.giveu.service;

import com.giveu.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();
    Dept getDeptById(Integer deptNo);
}
