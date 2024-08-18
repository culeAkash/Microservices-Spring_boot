package com.microservices.organisation_service.payloads;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganisationDTO {
    private Long organisation_id;
    private String organisationName;
    private String organisationDescription;
    private String organisationCode;
    private LocalDateTime organisationCreatedDate;
}
