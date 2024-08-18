package com.microservices.employee_service.services;

import com.microservices.employee_service.payloads.OrganisationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANISATION-SERVICE")
public interface APIOrganisationClient {
    @GetMapping("/api/v1/organisations/{organisationCode}")
    public OrganisationDTO getOrganisation(@PathVariable String organisationCode);
}
