package com.microservices.employee_service.services;

import com.microservices.employee_service.payloads.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("DEPARTMENT-SERVICE")
public interface APIDepartmentClient {
    @GetMapping("api/v1/departments/{departmentCode}")
    DepartmentDTO getDepartment(@PathVariable("departmentCode") String departmentCode);
}
