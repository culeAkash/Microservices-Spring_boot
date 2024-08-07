package com.microservices.department_service.services.impl;

import com.microservices.department_service.entities.Department;
import com.microservices.department_service.exceptions.ResourceNotFoundException;
import com.microservices.department_service.payloads.DepartmentDTO;
import com.microservices.department_service.repository.DepartmentRepository;
import com.microservices.department_service.services.DepartmentService;
import com.microservices.department_service.utils.PayloadConverterUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    private Environment environment;


    @Override
    public DepartmentDTO savedDepartment(DepartmentDTO departmentDTO) {

        Department department = PayloadConverterUtil.convertToDepartment(departmentDTO);

        // convert department to Department DTO
        Department savedDepartment = departmentRepository.save(department);

        return PayloadConverterUtil.convertToDepartmentDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode){
        System.out.println(environment.getProperty("local.server.port"));
        Department department = departmentRepository.getByDepartmentCode(departmentCode).orElseThrow(()->new ResourceNotFoundException("Department","Department code",departmentCode));

        return PayloadConverterUtil.convertToDepartmentDTO(department);

    }
}
