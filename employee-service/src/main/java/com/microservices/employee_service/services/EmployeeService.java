package com.microservices.employee_service.services;

import com.microservices.employee_service.payloads.ApiResponseDTO;
import com.microservices.employee_service.payloads.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    public ApiResponseDTO getEmployeeById(long id);

    public List<ApiResponseDTO> getAllEmployees();
}
