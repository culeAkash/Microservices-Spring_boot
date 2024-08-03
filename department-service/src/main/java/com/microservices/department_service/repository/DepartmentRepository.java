package com.microservices.department_service.repository;

import com.microservices.department_service.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department getByDepartmentCode(String departmentCode);
}
