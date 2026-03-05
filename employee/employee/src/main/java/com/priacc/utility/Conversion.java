package com.priacc.utility;

import com.priacc.dto.EmployeeForm;
import com.priacc.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class Conversion {
    public static Employee getEmployee(EmployeeForm employeeForm){
        Employee employee= Employee.builder()
                .id(employeeForm.getId())
                .name(employeeForm.getName())
                .salary(employeeForm.getSalary())
                .departmentId(employeeForm.getDepartmentId())
                .build();
        return employee;
    }

    public static EmployeeForm getEmployeeForm(Employee employee){
        EmployeeForm employeeForm=EmployeeForm.builder()
                .id(employee.getId())
                .name(employee.getName())
                .salary(employee.getSalary())
                .departmentId(employee.getDepartmentId())
                .build();
        return employeeForm;
    }
}
