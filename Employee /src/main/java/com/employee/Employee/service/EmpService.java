package com.employee.Employee.service;

import com.employee.Employee.entity.Department;
import com.employee.Employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmpService {
    Employee saveEmployee (Employee employee, List<Department> departments);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    List<Employee> getEmployeesByDepartmentId(int id);

}
