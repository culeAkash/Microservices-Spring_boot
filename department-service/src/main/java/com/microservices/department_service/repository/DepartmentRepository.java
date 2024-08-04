package com.microservices.department_service.repository;

import com.microservices.department_service.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> getByDepartmentCode(String departmentCode);
}
