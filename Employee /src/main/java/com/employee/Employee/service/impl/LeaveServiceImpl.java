package com.employee.Employee.service.impl;

import com.employee.Employee.dto.LeaveDetailsDTO;
import com.employee.Employee.entity.Leaves;
import com.employee.Employee.repository.LeaveRepo;
import com.employee.Employee.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepo leaveRepo;
    @Override
    public Leaves saveLeave(Leaves leaves) {
        LocalDateTime startDate = leaves.getStartDate();
        LocalDateTime endDate = leaves.getEndDate();
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        int days = Math.toIntExact(daysBetween);

        leaves.setDays(days);
        return leaveRepo.save(leaves);
    }
    @Override
    public List<Leaves> getAllLeaves() {
        return leaveRepo.findAll();
    }

    @Override
    public List<LeaveDetailsDTO> getLeavesByEmployeeId(int empId) {
        List<Leaves> leaves = leaveRepo.findByEmployee_EmpId(empId);
        List<LeaveDetailsDTO> leaveDetailsDTOList = new ArrayList<>();

        for (Leaves leave : leaves) {
            LeaveDetailsDTO leaveDetailsDTO = new LeaveDetailsDTO();
            leaveDetailsDTO.setLeaves(leave);
            leaveDetailsDTO.setEmpName(leave.getEmployee().getEmpName());
            leaveDetailsDTO.setEmail(leave.getEmployee().getEmail());
            leaveDetailsDTO.setDepartments(leave.getEmployee().getDepartments());
            leaveDetailsDTOList.add(leaveDetailsDTO);
        }

        return leaveDetailsDTOList;
    }

}
