package com.microservices.organisation_service.payloads;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(
        description = "Organisation DTO model info"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganisationDTO {
    private Long organisation_id;
    @Schema(
            description = "Organisation name"
    )
    private String organisationName;
    @Schema(
            description = "Organisation description"
    )
    private String organisationDescription;
    @Schema(
            description = "Organisation code"
    )
    private String organisationCode;
    @Schema(
            description = "Organisation creation date"
    )
    private LocalDateTime organisationCreatedDate;
}
