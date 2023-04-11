package com.employeeservice.service;

import com.employeeservice.entities.Employee;
import com.employeeservice.feigncommunication.Department;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> fetchAllEmployee();
    public Employee fetchEmployeeById (Integer emp_id);
    public Department fetchEmployeeDepartment(Integer dept_id);

}
