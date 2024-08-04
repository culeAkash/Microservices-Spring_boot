package com.microservices.employee_service.services;

import com.microservices.employee_service.payloads.EmployeeDTO;

public interface EmployeeService {

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    public EmployeeDTO getEmployeeById(long id);
}
