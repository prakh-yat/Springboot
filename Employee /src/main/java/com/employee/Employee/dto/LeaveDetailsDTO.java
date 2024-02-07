package com.employee.Employee.dto;

import com.employee.Employee.entity.Department;
import com.employee.Employee.entity.Leaves;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LeaveDetailsDTO {
    private Leaves leaves;
    private String empName;
    private String email;
    private List<Department> departments;
}
