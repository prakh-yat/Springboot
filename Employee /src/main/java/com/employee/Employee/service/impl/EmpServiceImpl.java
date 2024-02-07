package com.employee.Employee.service.impl;

import com.employee.Employee.entity.Department;
import com.employee.Employee.entity.Employee;
import com.employee.Employee.repository.DepRepo;
import com.employee.Employee.repository.EmpRepo;
import com.employee.Employee.service.EmpService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private DepRepo depRepo;


    @Override
    public Employee saveEmployee(Employee employee, List<Department> departments) {
        employee.setDepartments(departments);
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = empRepo.findAll();
        employees.forEach(employee -> {
            employee.getLeaves();
            employee.getDepartments();

        });
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = empRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.getDepartments();
            return employee;
        } else {
            throw new EntityNotFoundException("Employee not found with id: " + id);
        }
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int id) {
        Optional<Department> departmentOptional = depRepo.findById(id);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            List<Employee> employees = department.getEmployees();
            return employees;
        } else {
            return Collections.emptyList();
        }
    }
}
