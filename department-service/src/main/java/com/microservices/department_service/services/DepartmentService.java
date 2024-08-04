package com.microservices.department_service.services;

import com.microservices.department_service.exceptions.ResourceNotFoundException;
import com.microservices.department_service.payloads.DepartmentDTO;

public interface DepartmentService {
    public DepartmentDTO savedDepartment(DepartmentDTO departmentDTO);


    public DepartmentDTO getDepartmentByCode(String code) ;
}
