package com.departmentservice.feigncommunication;

import com.departmentservice.feignconfiguration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface IEmployeeService {
        @GetMapping(value = "/v1.0/employee/get-employee-by-id/{emp_id}")
        public Employee fetchEmpById(@PathVariable("emp_id") Integer emp_id);
}
