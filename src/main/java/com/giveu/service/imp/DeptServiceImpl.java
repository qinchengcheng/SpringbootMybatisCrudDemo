package com.giveu.service.imp;

import com.giveu.dao.DeptDAO;
import com.giveu.entity.Dept;
import com.giveu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @SuppressWarnings("all")
    @Autowired
    DeptDAO deptDAO;

    @Override
    public List<Dept> list() {
        return deptDAO.list();
    }
    public Dept getDeptById(Integer deptNo){
        return deptDAO.getDeptById(deptNo);
    }
}
