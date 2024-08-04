package com.microservices.employee_service.controllers;

import com.microservices.employee_service.payloads.EmployeeDTO;
import com.microservices.employee_service.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {


    private EmployeeService employeeService;

    // Build save employee rest api
    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);

        return new ResponseEntity<EmployeeDTO>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping("/getEmployee/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable  Long employeeId) {
         EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);

         if (employeeDTO == null) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }
}
