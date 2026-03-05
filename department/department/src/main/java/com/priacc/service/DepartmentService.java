package com.priacc.service;

import com.priacc.entity.Department;
import com.priacc.exception.DepartmentNOTFoundException;
import com.priacc.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public Department saveDepartment(Department department){
       return departmentRepository.save(department);
    }
    public Department updateDepartment(Department department){
        return departmentRepository.save(department);
    }
    public Department getDepartmentBYId(Long id) throws DepartmentNOTFoundException {
        Optional<Department> dept=departmentRepository.findById(id);
        if(dept.isPresent()) return dept.get();
        throw new DepartmentNOTFoundException("department not found exception");
    }
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public void deleteDepartmentBYId(Long id){
         departmentRepository.deleteById(id);;
    }



}
