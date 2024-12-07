package com.image.innovate.employee.controller;


import com.image.innovate.employee.dto.EmployeeTaxResponse;
import com.image.innovate.employee.model.Employee;
import com.image.innovate.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/{employeeId}/tax")
    public ResponseEntity<EmployeeTaxResponse> getEmployeeTax(@PathVariable Long employeeId) {
        EmployeeTaxResponse taxResponse = employeeService.calculateEmployeeTax(employeeId);
        return ResponseEntity.ok(taxResponse);
    }

}
