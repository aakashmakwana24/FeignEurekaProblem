package com.employeeservice.controller;

import com.employeeservice.entities.Employee;
import com.employeeservice.feigncommunication.Department;
import com.employeeservice.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${employee-service-version}/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/get-all-employee")
    public List<Employee> getAllEmployee(){
        return this.employeeService.fetchAllEmployee();
    }

    @GetMapping("/get-employee-by-id/{emp_id}")
    public Employee getEmployeeById(@PathVariable("emp_id") Integer emp_id){
        return this.employeeService.fetchEmployeeById(emp_id);
    }

    @GetMapping(value="/get-employee-by-dept/{dept_id}",produces = "application/json")
    public Department getEmployeeDepartment(@PathVariable("dept_id") Integer dept_id){
        return this.employeeService.fetchEmployeeDepartment(dept_id);
    }

}