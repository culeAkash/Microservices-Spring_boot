package com.microservices.organisation_service.controllers;

import com.microservices.organisation_service.payloads.OrganisationDTO;
import com.microservices.organisation_service.services.OrganisationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organisations")
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;

    @Operation(
            summary = "Save Organisation REST API",
            description = "Save Organisation REST API is used to save Organisation object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 - Created"
    )
    @PostMapping("/createOrg")
    public ResponseEntity<OrganisationDTO> saveOrganisation(@RequestBody OrganisationDTO organisationDTO){
        OrganisationDTO savedOrganisation =organisationService.saveOrganisation(organisationDTO);

        System.out.println(savedOrganisation);

        return new ResponseEntity<>(savedOrganisation, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organisation REST API",
            description = "Get Organisation REST API is used to get Organisation object in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 - OK"
    )
    @GetMapping("/{organisationCode}")
    public ResponseEntity<OrganisationDTO> getOrganisation(@PathVariable String organisationCode){
        OrganisationDTO organisationDTO = organisationService.getOrganisationByCode(organisationCode);
        return new ResponseEntity<>(organisationDTO,HttpStatus.OK);
    }
}
