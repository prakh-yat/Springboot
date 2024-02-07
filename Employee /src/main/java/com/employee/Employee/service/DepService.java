package com.employee.Employee.service;

import com.employee.Employee.entity.Department;
import com.employee.Employee.entity.Leaves;

import java.util.List;

public interface DepService {
    Department saveDepartment (Department department);
    List<Department> getAllDepartment();

    Department getDepartmentById(int id);

}
