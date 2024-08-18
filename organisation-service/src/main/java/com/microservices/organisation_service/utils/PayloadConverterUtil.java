package com.microservices.organisation_service.utils;

import com.microservices.organisation_service.entities.Organisation;
import com.microservices.organisation_service.payloads.OrganisationDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

//@AllArgsConstructor
public class PayloadConverterUtil {


    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public static Organisation convertToOrganisation(OrganisationDTO organisationDTO){
        return MODEL_MAPPER.map(organisationDTO,Organisation.class);
    }

    public static OrganisationDTO convertToOrganisationDTO(Organisation organisation){
        return MODEL_MAPPER.map(organisation,OrganisationDTO.class);
    }


}
