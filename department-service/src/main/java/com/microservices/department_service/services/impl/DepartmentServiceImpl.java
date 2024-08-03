package com.microservices.department_service.services.impl;

import com.microservices.department_service.entities.Department;
import com.microservices.department_service.payloads.DepartmentDTO;
import com.microservices.department_service.repository.DepartmentRepository;
import com.microservices.department_service.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDTO savedDepartment(DepartmentDTO departmentDTO) {

        Department department = new Department(
                departmentDTO.getDepartmentId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode());

        // convert department to Department DTO
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDTO savedDepartmentDTO = new DepartmentDTO();
        savedDepartmentDTO.setDepartmentId(savedDepartment.getDepartmentId());
        savedDepartmentDTO.setDepartmentName(savedDepartment.getDepartmentName());
        savedDepartmentDTO.setDepartmentDescription(savedDepartment.getDepartmentDescription());
        savedDepartmentDTO.setDepartmentCode(savedDepartment.getDepartmentCode());

        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.getByDepartmentCode(departmentCode);

        DepartmentDTO savedDepartmentDTO = new DepartmentDTO();
        savedDepartmentDTO.setDepartmentId(department.getDepartmentId());
        savedDepartmentDTO.setDepartmentName(department.getDepartmentName());
        savedDepartmentDTO.setDepartmentDescription(department.getDepartmentDescription());
        savedDepartmentDTO.setDepartmentCode(department.getDepartmentCode());

        return savedDepartmentDTO;
    }
}
