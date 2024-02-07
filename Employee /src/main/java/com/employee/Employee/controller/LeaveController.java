package com.employee.Employee.controller;


import com.employee.Employee.entity.Employee;
import com.employee.Employee.entity.Leaves;
import com.employee.Employee.dto.LeaveDetailsDTO;

import com.employee.Employee.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @PostMapping
    public ResponseEntity<Leaves> createLeave(@RequestBody Leaves leaves){
         Leaves leave = leaveService.saveLeave(leaves);
        return ResponseEntity.status(HttpStatus.CREATED).body(leave);
    }

    @GetMapping
    public ResponseEntity<List<Leaves>> getAllLeaves (){
        List<Leaves> allLeaves = leaveService.getAllLeaves();
        return ResponseEntity.ok(allLeaves);
    }



    @GetMapping("/{empId}")
    public ResponseEntity<List<LeaveDetailsDTO>> getLeavesByEmployeeId(@PathVariable int empId) {
        List<LeaveDetailsDTO> leaveDetailsDTOList = leaveService.getLeavesByEmployeeId(empId);
        return ResponseEntity.ok(leaveDetailsDTOList);
    }


}
