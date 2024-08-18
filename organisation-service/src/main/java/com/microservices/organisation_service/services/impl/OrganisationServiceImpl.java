package com.microservices.organisation_service.services.impl;

import com.microservices.organisation_service.entities.Organisation;
import com.microservices.organisation_service.payloads.OrganisationDTO;
import com.microservices.organisation_service.repositories.OrganisationRepository;
import com.microservices.organisation_service.services.OrganisationService;
import com.microservices.organisation_service.utils.PayloadConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganisationServiceImpl implements OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Override
    public OrganisationDTO saveOrganisation(OrganisationDTO organisationDTO) {

        Organisation organisation = PayloadConverterUtil.convertToOrganisation(organisationDTO);

        Organisation savedOrganisation = organisationRepository.save(organisation);
        System.out.println(savedOrganisation);
        OrganisationDTO savedOrganisationDTO = PayloadConverterUtil.convertToOrganisationDTO(savedOrganisation);
        System.out.println(savedOrganisationDTO);
        return savedOrganisationDTO;
    }

    @Override
    public OrganisationDTO getOrganisationByCode(String organisationCode) {
       Optional<Organisation> organisationOptional = organisationRepository.getByOrganisationCode(organisationCode);
       Organisation organisation = organisationOptional.get();
       return PayloadConverterUtil.convertToOrganisationDTO(organisation);
    }
}
