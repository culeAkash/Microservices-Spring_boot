package com.microservices.department_service.payloads;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long departmentId;
    private String departmentName;
    private String DepartmentDescription;
    private String departmentCode;
}
