package com.employee.Employee.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "leaves")
@ToString
public class Leaves {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaveId;
    private String subject;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int days;



    @ManyToOne
    @JoinColumn(name = "empId")
    @JsonBackReference
    private Employee employee;


}


