package com.microservices.employee_service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private long departmentId;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
