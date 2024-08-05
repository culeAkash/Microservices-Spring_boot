package com.microservices.employee_service.payloads;

//import jakarta.persistence.Column;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeePhone;
    private String employeeEmail;
    private String employeePassword;
    private String departmentCode;

}
