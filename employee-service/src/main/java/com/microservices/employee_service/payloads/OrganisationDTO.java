package com.microservices.employee_service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationDTO {
    private Long organisation_id;
    private String organisationName;
    private String organisationDescription;
    private String organisationCode;
    private LocalDateTime organisationCreatedDate;
}
