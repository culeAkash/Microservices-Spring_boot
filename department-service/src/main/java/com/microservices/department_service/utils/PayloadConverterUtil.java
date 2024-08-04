package com.microservices.department_service.utils;



import com.microservices.department_service.entities.Department;
import com.microservices.department_service.payloads.DepartmentDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

//@AllArgsConstructor
public class PayloadConverterUtil {
    static ModelMapper mapper = new ModelMapper();

    public static DepartmentDTO convertToDepartmentDTO(Department department) {
        return mapper.map(department, DepartmentDTO.class);
    }

    public static Department convertToDepartment(DepartmentDTO departmentDTO) {
        return mapper.map(departmentDTO, Department.class);
    }
}

