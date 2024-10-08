package com.microservices.employee_service.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeePhone;
    @Column(nullable = false,unique = true)
    private String employeeEmail;
    private String employeePassword;


    private String departmentCode;
    private String organisationCode;
}
