package com.employee.Employee.service.impl;

import com.employee.Employee.entity.Department;
import com.employee.Employee.entity.Employee;
import com.employee.Employee.repository.DepRepo;
import com.employee.Employee.service.DepService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepServiceImpl implements DepService {

    @Autowired
    private DepRepo depRepo;
    @Override
    public Department saveDepartment(Department department) {

        return depRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return depRepo.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        return depRepo.findById(id).orElse(null);
    }

}
