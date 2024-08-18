package com.microservices.organisation_service.services;

import com.microservices.organisation_service.payloads.OrganisationDTO;

public interface OrganisationService {

    public OrganisationDTO saveOrganisation(OrganisationDTO organisationDTO);

    public OrganisationDTO getOrganisationByCode(String organisationCode);
}
