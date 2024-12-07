package com.image.innovate.employee.service;

import com.image.innovate.employee.dao.EmployeeRepository;
import com.image.innovate.employee.dto.EmployeeTaxResponse;
import com.image.innovate.employee.model.Employee;
import com.image.innovate.employee.util.EmployeeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeTaxResponse calculateEmployeeTax(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();

        double totalSalary = EmployeeUtils.calculateTotalSalary(employee);
        double taxAmount = EmployeeUtils.calculateTaxAmount(totalSalary);
        double cessAmount = EmployeeUtils.calculateCessAmount(totalSalary);

        EmployeeTaxResponse taxResponse = new EmployeeTaxResponse();
        taxResponse.setEmployeeId(employee.getEmployeeId());
        taxResponse.setFirstName(employee.getFirstName());
        taxResponse.setLastName(employee.getLastName());
        taxResponse.setYearlySalary(totalSalary);
        taxResponse.setTaxAmount(taxAmount);
        taxResponse.setCessAmount(cessAmount);

        return taxResponse;
    }





}

