package com.employee.Employee.service;



import com.employee.Employee.dto.LeaveDetailsDTO;
import com.employee.Employee.entity.Leaves;

import java.util.List;

public interface LeaveService {
    Leaves saveLeave (Leaves leaves);

    List<Leaves> getAllLeaves();

    List<LeaveDetailsDTO> getLeavesByEmployeeId(int epmId);





}
