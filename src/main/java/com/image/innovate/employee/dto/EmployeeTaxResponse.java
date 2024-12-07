package com.image.innovate.employee.dto;

import lombok.Data;

@Data
public class EmployeeTaxResponse {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private double yearlySalary;
    private double taxAmount;
    private double cessAmount;

}
