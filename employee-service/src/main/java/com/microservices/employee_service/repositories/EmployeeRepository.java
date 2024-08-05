package com.microservices.employee_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.employee_service.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
