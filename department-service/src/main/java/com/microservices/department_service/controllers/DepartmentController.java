package com.microservices.department_service.controllers;

import com.microservices.department_service.exceptions.ResourceNotFoundException;
import com.microservices.department_service.payloads.DepartmentDTO;
import com.microservices.department_service.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/v1/departments")
@AllArgsConstructor
public class DepartmentController {


    private DepartmentService departmentService;



    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO department) {
          DepartmentDTO savedDepartment = departmentService.savedDepartment(department);
          return new ResponseEntity<DepartmentDTO>(savedDepartment,HttpStatus.CREATED);
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable String departmentCode){
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }

}
