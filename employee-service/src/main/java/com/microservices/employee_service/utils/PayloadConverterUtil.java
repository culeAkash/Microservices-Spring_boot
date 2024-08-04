package com.microservices.employee_service.utils;

import com.microservices.employee_service.Entities.Employee;
import com.microservices.employee_service.payloads.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

//@AllArgsConstructor
public class PayloadConverterUtil {
    static ModelMapper mapper = new ModelMapper();

    public static EmployeeDTO convertToEmployeeDTO(Employee employee) {
        return mapper.map(employee, EmployeeDTO.class);
    }

    public static Employee convertToEmployee(EmployeeDTO employeeDTO) {
        return mapper.map(employeeDTO, Employee.class);
    }
}
