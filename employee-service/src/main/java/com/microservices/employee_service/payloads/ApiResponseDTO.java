package com.microservices.employee_service.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDTO {
    private EmployeeDTO employee;
    private DepartmentDTO department;
}
