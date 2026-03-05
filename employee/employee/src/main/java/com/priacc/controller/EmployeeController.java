package com.priacc.controller;
import com.priacc.dto.EmployeeForm;
import com.priacc.dto.Response;
import com.priacc.entity.Employee;
import com.priacc.exception.EmployeeNotFoundException;
import com.priacc.repository.EmployeeRepository;
import com.priacc.service.EmployeeService;
import com.priacc.utility.Conversion;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final Conversion conversion;

    @PostMapping("/saveEmployee")
    @Transactional(rollbackForClassName = {"java.lang.exception"})
    public EmployeeForm saveEmployee(@RequestBody EmployeeForm employeeForm){
        Employee employee=Conversion.getEmployee(employeeForm);
        employeeService.saveEmployee(employee);
        return conversion.getEmployeeForm(employee);

    }

    @PutMapping("/updateEmployee")
    @Transactional(rollbackForClassName = {"java.lang.exception"})
    public EmployeeForm updateEmployee(@RequestBody EmployeeForm employeeForm){
        Employee employee=Conversion.getEmployee(employeeForm);
        employeeService.updateEmployee(employee);
        return conversion.getEmployeeForm(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @Transactional(rollbackForClassName = {"java.lang.exception"})
    public void deleteEmployeeBYId(@PathVariable Long id) {
        employeeService.deleteEmployeeBYId(id);
    }

    @GetMapping("/getEmployee/{id}")
    public Response getEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeBYId(id);
    }

    @GetMapping("/getAllEmployee")
    public List<EmployeeForm> getAllEmployees(){
        List<Employee> employees= employeeService.getAllEmployees();
        List<EmployeeForm> empForms=new ArrayList<>();
        for(Employee emp:employees)
        {
            empForms.add(conversion.getEmployeeForm(emp));
        }
        return empForms;
    }


}

