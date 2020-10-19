package com.lgl.dao;

import com.lgl.domain.Department;

import java.util.List;

public interface IDepartmentDao {

    List<Department> findAll();

    void save(Department dept);
    //delete from department where did = 5;
    void deleteById(int id);


    void update(Department dept);

    Department findById(int did);

}
