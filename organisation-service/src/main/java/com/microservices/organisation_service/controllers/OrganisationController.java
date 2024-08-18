package com.microservices.organisation_service.controllers;

import com.microservices.organisation_service.payloads.OrganisationDTO;
import com.microservices.organisation_service.services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organisations")
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;

    @PostMapping("/createOrg")
    public ResponseEntity<OrganisationDTO> saveOrganisation(@RequestBody OrganisationDTO organisationDTO){
        OrganisationDTO savedOrganisation =organisationService.saveOrganisation(organisationDTO);

        System.out.println(savedOrganisation);

        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }

    @GetMapping("/{organisationCode}")
    public ResponseEntity<OrganisationDTO> getOrganisation(@PathVariable String organisationCode){
        OrganisationDTO organisationDTO = organisationService.getOrganisationByCode(organisationCode);
        return new ResponseEntity<>(organisationDTO,HttpStatus.OK);
    }
}
