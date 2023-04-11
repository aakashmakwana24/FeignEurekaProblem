package com.employeeservice.feigncommunication;

import com.employeeservice.feignconfiguration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "DEPARTMENT-SERVICE", configuration = FeignConfiguration.class)
public interface IDepartmentService {

    @GetMapping(value = "/v1.0/department/get-department-by-id/{dept_id}")
    public Department fetchDepartmentById(@PathVariable("dept_id") Integer dept_id);

}
