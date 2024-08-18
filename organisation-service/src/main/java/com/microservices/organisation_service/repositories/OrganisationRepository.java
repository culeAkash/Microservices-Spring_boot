package com.microservices.organisation_service.repositories;

import com.microservices.organisation_service.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation,Long> {
    public Optional<Organisation> getByOrganisationCode(String organisationCode);
}
