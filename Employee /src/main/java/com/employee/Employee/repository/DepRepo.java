package com.employee.Employee.repository;

import com.employee.Employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepRepo extends JpaRepository<Department,Integer> {


}
