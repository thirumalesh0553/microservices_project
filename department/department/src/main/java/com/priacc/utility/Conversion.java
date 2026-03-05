package com.priacc.utility;

import com.priacc.dto.DepartmentForm;
import com.priacc.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class Conversion {
    public Department getDepartment(DepartmentForm departmentForm){
        Department department= Department.builder()
                .departmentId(departmentForm.getDepartmentId())
                    .departmentName(departmentForm.getDepartmentName())
                    .departmentLocation(departmentForm.getDepartmentLocation())
                    .build();
        return department;
    }

    public DepartmentForm getDepartmentForm(Department department){
        DepartmentForm departmentForm=DepartmentForm.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .departmentLocation(department.getDepartmentLocation())
                .build();
        return departmentForm;
    }
}
