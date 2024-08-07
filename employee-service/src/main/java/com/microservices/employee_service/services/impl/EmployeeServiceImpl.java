package com.microservices.employee_service.services.impl;

import com.microservices.employee_service.entities.Employee;
import com.microservices.employee_service.exceptions.ResourceNotFoundException;
import com.microservices.employee_service.payloads.ApiResponseDTO;
import com.microservices.employee_service.payloads.DepartmentDTO;
import com.microservices.employee_service.payloads.EmployeeDTO;
import com.microservices.employee_service.repositories.EmployeeRepository;
import com.microservices.employee_service.services.APIClient;
import com.microservices.employee_service.services.EmployeeService;
import com.microservices.employee_service.utils.PayloadConverterUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    private Environment environment;

//    private RestTemplate restTemplate;

    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = PayloadConverterUtil.convertToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return PayloadConverterUtil.convertToEmployeeDTO(savedEmployee);
    }

    @Override
    public ApiResponseDTO getEmployeeById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        Employee employee = employeeOptional.orElseThrow(()->new ResourceNotFoundException("Employee","Employee id",id));

//        ResponseEntity<DepartmentDTO> responseEntity =  restTemplate.getForEntity("http://localhost:8080/api/v1/departments/"+employee.getDepartmentCode(), DepartmentDTO.class);
        //Using Web client
        DepartmentDTO departmentDTO = apiClient.getDepartment(employee.getDepartmentCode());

//                webClient.get()
//                .uri("/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .onStatus(httpStatus -> httpStatus.value() == 404
//                        ,error-> Mono.error(new ResourceNotFoundException("Department","Department code",employee.getDepartmentCode())))
//                .bodyToMono(DepartmentDTO.class)
//                .block();// for making a synchronous call we are calling the block method

//        DepartmentDTO departmentDTO = responseEntity.getBody();


        EmployeeDTO employeeDTO = PayloadConverterUtil.convertToEmployeeDTO(employee);

        return new ApiResponseDTO(employeeDTO,departmentDTO);
    }

    @Override
    public List<ApiResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        System.out.println(environment.getProperty("local.server.port"));

        List<ApiResponseDTO> apiResponseDTOS = new ArrayList<>();
        for(Employee employee : employees) {
             DepartmentDTO departmentDTO =  apiClient.getDepartment(employee.getDepartmentCode());
//                     webClient.get()
//                    .uri("/departments/"+employee.getDepartmentCode())
//                    .retrieve()
//                     .onStatus(httpStatus -> httpStatus.value() == 404
//                             ,error-> Mono.error(new ResourceNotFoundException("Department","Department code",employee.getDepartmentCode())))
//                    .bodyToMono(DepartmentDTO.class)
//                    .block();

             EmployeeDTO employeeDTO = PayloadConverterUtil.convertToEmployeeDTO(employee);
            apiResponseDTOS.add(new ApiResponseDTO(employeeDTO,departmentDTO));
        }

        return apiResponseDTOS;
    }


}
