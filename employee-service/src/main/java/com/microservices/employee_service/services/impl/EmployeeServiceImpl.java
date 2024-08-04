package com.microservices.employee_service.services.impl;

import com.microservices.employee_service.Entities.Employee;
import com.microservices.employee_service.exceptions.ResourceNotFoundException;
import com.microservices.employee_service.payloads.EmployeeDTO;
import com.microservices.employee_service.repositories.EmployeeRepository;
import com.microservices.employee_service.services.EmployeeService;
import com.microservices.employee_service.utils.PayloadConverterUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = PayloadConverterUtil.convertToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return PayloadConverterUtil.convertToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        Employee employee = employeeOptional.orElseThrow(()->new ResourceNotFoundException("Employee","Employee id",id));
        return PayloadConverterUtil.convertToEmployeeDTO(employee);
    }
}
