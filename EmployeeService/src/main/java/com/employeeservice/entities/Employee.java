package com.employeeservice.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @JsonProperty("employee id")
    private Integer employeeId;
    @JsonProperty("employee name")
    private String employeeName;
    @JsonProperty("employee email")
    private String employeeEmail;
    @JsonProperty("department name")
    private String departmentName;

}
