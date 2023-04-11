package com.departmentservice.serviceimpl;

import com.departmentservice.entities.Department;
import com.departmentservice.service.IDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class DepartmentServiceImpl implements IDepartmentService {
    @Override
    public List<Department> fetchAllDepartments() {
        return List.of(new Department(1,"Java",350,"Harvey Specter"),
                new Department(2,".NET",325,"Louis Litt"),
                new Department(3,".JS",300,"Mike Ross"),
                new Department(4,".BlockChain",295,"Travis Tanner"));
    }

    @Override
    public Department fetchDepartmentById(Integer dept_id) {
        log.info("got hit from external service");
        return new Department(1,"Java",350,"Harvey Specter");
    }
}
