package com.departmentservice.feigncommunication;

import com.fasterxml.jackson.annotation.JsonProperty;

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
