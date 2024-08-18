package com.microservices.employee_service.payloads;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponseDTO {
    private EmployeeDTO employee;
    private DepartmentDTO department;
    private OrganisationDTO organisation;
}
