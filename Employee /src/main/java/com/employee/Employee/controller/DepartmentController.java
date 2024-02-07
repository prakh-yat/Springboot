package com.employee.Employee.controller;

import com.employee.Employee.entity.Department;
import com.employee.Employee.entity.Employee;
import com.employee.Employee.entity.Leaves;
import com.employee.Employee.service.DepService;
import com.employee.Employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

     @Autowired
    private DepService depService;



    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department saveDepartment = depService.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveDepartment);
    }


    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment (){
        List<Department> allDepartment = depService.getAllDepartment();
        return ResponseEntity.ok(allDepartment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        Department department = depService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }
}
