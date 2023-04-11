package com.departmentservice.service;

import com.departmentservice.entities.Department;

import java.util.List;


public interface IDepartmentService {
    public List<Department> fetchAllDepartments();
    public Department fetchDepartmentById(Integer dept_id);


}
