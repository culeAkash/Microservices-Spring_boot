package com.microservices.department_service.payloads;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;



@Schema(
        description = "Department DTO model info"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {


    private Long departmentId;

    @Schema(
            description = "Department name"
    )
    private String departmentName;
    @Schema(
            description = "Department description"
    )
    private String DepartmentDescription;
    @Schema(
            description = "Department code"
    )
    private String departmentCode;
}
