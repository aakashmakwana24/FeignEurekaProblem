package com.departmentservice.controller;

import com.departmentservice.entities.Department;
import com.departmentservice.feigncommunication.Employee;
import com.departmentservice.feigncommunication.IEmployeeService;
import com.departmentservice.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${department-service-version}/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService DepartmentService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = "/get-all-department")
    public List<Department> fetchAllDepartments(){
        return DepartmentService.fetchAllDepartments();
    }

    @GetMapping(value = "/get-department-by-id/{dept_id}")
    public Department fetchDepartmentById(@PathVariable("dept_id") Integer dept_id){
        return DepartmentService.fetchDepartmentById(dept_id);
    }

    @GetMapping(value = "/get-emp-by-id/{dept_id}")
    public Employee fetchEmpById(@PathVariable("dept_id") Integer dept_id){
        return employeeService.fetchEmpById(dept_id);
    }

}
