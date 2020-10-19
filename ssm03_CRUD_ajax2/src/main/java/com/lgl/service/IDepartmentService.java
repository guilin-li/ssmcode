package com.lgl.service;

import com.lgl.domain.Department;

import java.util.List;

public interface IDepartmentService {

    List<Department> findAllDepartments();

    void saveDepartment(Department dept);

    void deleteDepartmentById(int id);

    void updateDepartmentById(Department dept);

    Department findDepartmentById(int did);

}
