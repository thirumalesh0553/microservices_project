package com.priacc.controller;

import com.priacc.dto.DepartmentForm;
import com.priacc.entity.Department;
import com.priacc.exception.DepartmentNOTFoundException;
import com.priacc.repository.DepartmentRepository;
import com.priacc.service.DepartmentService;
import com.priacc.utility.Conversion;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final Conversion conversion;

    @PostMapping("/saveDepartment")
    @Transactional(rollbackForClassName = {"java.lang.exception"})
    public DepartmentForm saveDepartment(@RequestBody DepartmentForm departmentForm){
        Department department=conversion.getDepartment(departmentForm);
         departmentService.saveDepartment(department);
         return conversion.getDepartmentForm(department);

    }

    @PutMapping("/updateDepartment")
    @Transactional(rollbackForClassName = {"java.lang.exception"})
    public DepartmentForm updateDepartment(@RequestBody DepartmentForm departmentForm){
        Department department=conversion.getDepartment(departmentForm);
         departmentService.updateDepartment(department);
         return conversion.getDepartmentForm(department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    @Transactional(rollbackForClassName = {"java.lang.exception"})
    public void deleteDepartmentBYId(@PathVariable Long id) {
        departmentService.deleteDepartmentBYId(id);
    }

    @GetMapping("/getDepartment/{id}")
    public DepartmentForm getDepartment(@PathVariable Long id) throws DepartmentNOTFoundException {
       Department department= departmentService.getDepartmentBYId(id);
        return conversion.getDepartmentForm(department);
    }

    @GetMapping("/getAllDepartment")
    public List<DepartmentForm> getAllDepartments(){
        List<Department> departments= departmentService.getAllDepartments();
        List<DepartmentForm> deptForms=new ArrayList<>();
        for(Department dept:departments)
        {
            deptForms.add(conversion.getDepartmentForm(dept));
        }
        return deptForms;
    }


}
