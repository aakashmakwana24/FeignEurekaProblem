package com.employeeservice.serviceimpl;

import com.employeeservice.entities.Employee;
import com.employeeservice.feigncommunication.Department;
import com.employeeservice.feigncommunication.IDepartmentService;
import com.employeeservice.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IDepartmentService departmentService;
    @Override
    public List<Employee> fetchAllEmployee() {
        return List.of(new Employee(1, "Aakash Makwana", "aakash@gmail.com", "Java"),
                new Employee(2, "Shreyash Kashyap", "shreyash@gmail.com", "Java"),
                new Employee(3, "Akshat Jain", "akshat@gmail.com", "Java"));
    }

    @Override
    public Employee fetchEmployeeById(Integer emp_id) {
        return new Employee(2, "Shreyash Kashyap", "shreyash@gmail.com", "Java");
    }

    @Override
    public Department fetchEmployeeDepartment(Integer dept_id) {

        return this.departmentService.fetchDepartmentById(dept_id);

    }
}
