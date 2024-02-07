package com.employee.Employee.controller;

import com.employee.Employee.entity.Department;
import com.employee.Employee.entity.Employee;
import com.employee.Employee.service.DepService;
import com.employee.Employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DepService depService;



//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(
//            @RequestBody Employee employee,
//            @RequestParam(name="depId") int depId) {
//
//
//        Department department = depService.getDepartmentById(depId);
//
//        Employee emp = empService.saveEmployee(employee, department);
//        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
//    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee,
            @RequestParam(name = "depId") List<Integer> depId) {

        List<Department> departments = new ArrayList<>();
        for (Integer id : depId) {
            Department department = depService.getDepartmentById(id);
            departments.add(department);
        }

        Employee emp = empService.saveEmployee(employee, departments);
        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee (){
        List<Employee> allEmployees = empService.getAllEmployee();
        return ResponseEntity.ok(allEmployees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = empService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartmentId(@PathVariable int id) {
        List<Employee> employees = empService.getEmployeesByDepartmentId(id);

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
    }




}
