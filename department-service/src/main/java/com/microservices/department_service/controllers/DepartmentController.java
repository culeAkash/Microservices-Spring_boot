package com.microservices.department_service.controllers;

import com.microservices.department_service.exceptions.ResourceNotFoundException;
import com.microservices.department_service.payloads.DepartmentDTO;
import com.microservices.department_service.services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//Swagger config for department controller
@Tag(
        name = "Department Service - Controller",
        description = "Rest Controller exposes REST APIs for Department Service"
)
@Controller
@RestController
@RequestMapping("/api/v1/departments")
@AllArgsConstructor
public class DepartmentController {


    private DepartmentService departmentService;


    @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is used to save department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 - Created"
    )
    @PostMapping("/createDepartment")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO department) {
          DepartmentDTO savedDepartment = departmentService.savedDepartment(department);
          return new ResponseEntity<DepartmentDTO>(savedDepartment,HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Department REST API",
            description = "Get Department REST API is used to get department object in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 - OK"
    )
    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable String departmentCode){
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }

}
