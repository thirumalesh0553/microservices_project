package com.priacc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeForm {
    private Long id;
    private String name;
    private Double salary;
    private Long departmentId;
}

