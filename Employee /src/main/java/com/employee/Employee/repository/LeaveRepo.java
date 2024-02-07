package com.employee.Employee.repository;

import com.employee.Employee.entity.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepo extends JpaRepository<Leaves,Integer> {
    List<Leaves> findByEmployee_EmpId(int empId);
}
