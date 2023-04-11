package com.departmentservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @JsonProperty("department id")
    private Integer departmentId;
    @JsonProperty("department name")
    private String departmentName;
    @JsonProperty("total employee")
    private Integer totalEmployee;
    @JsonProperty("department HOD")
    private String departmentHod;

}
