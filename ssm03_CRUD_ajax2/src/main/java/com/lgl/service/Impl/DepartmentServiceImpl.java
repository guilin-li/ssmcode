package com.lgl.service.Impl;

import com.lgl.dao.IDepartmentDao;
import com.lgl.dao.IPersonDao;
import com.lgl.domain.Department;
import com.lgl.domain.Person;
import com.lgl.service.IDepartmentService;
import com.lgl.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

    @Autowired
    private IDepartmentDao dao;
    @Override
    public List<Department> findAllDepartments() {
        List<Department> list = dao.findAll();
        return list;
    }
    @Override
    public void saveDepartment(Department dept) {
        dao.save(dept);
    }

    @Override
    public void deleteDepartmentById(int id) {
        dao.deleteById(id);

    }

    @Override
    public void updateDepartmentById(Department dept) {
        dao.update(dept);

    }

    @Override
    public Department findDepartmentById(int did) {
        return dao.findById(did);
    }

}
