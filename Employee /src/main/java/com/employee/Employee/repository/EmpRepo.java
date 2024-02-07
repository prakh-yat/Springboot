package com.employee.Employee.repository;

import com.employee.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepo extends JpaRepository <Employee,Integer> {
}
