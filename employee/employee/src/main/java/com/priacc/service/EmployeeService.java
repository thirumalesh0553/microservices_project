package com.priacc.service;

import com.priacc.dto.DepartmentForm;
import com.priacc.dto.EmployeeForm;
import com.priacc.dto.Response;
import com.priacc.entity.Employee;
import com.priacc.exception.EmployeeNotFoundException;
import com.priacc.repository.EmployeeRepository;
import com.priacc.utility.Conversion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Conversion conversion;
    private final RestTemplate restTemplate;
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Response getEmployeeBYId(Long id) throws EmployeeNotFoundException {
        Response response=new Response();
        EmployeeForm eform=null;
        Optional<Employee> emp=employeeRepository.findById(id);
        if(emp.isPresent()) {
            eform=Conversion.getEmployeeForm(emp.get());
            response.setEmployeeForm(eform);

        }
        else throw new EmployeeNotFoundException("employee not found exception");
        DepartmentForm departmentForm=restTemplate.getForObject("http://localhost:9191/dept/getDepartment"+eform.getId(), DepartmentForm.class);
        response.setDepartmentForm(departmentForm);
        return response;
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployeeBYId(Long id){
        employeeRepository.deleteById(id);
    }

}

