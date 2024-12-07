package com.image.innovate.employee.util;

import com.image.innovate.employee.model.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.image.innovate.employee.constants.EmployeeConstants.*;

public class EmployeeUtils {


    public static double calculateTotalSalary(Employee employee) {
        LocalDate currentDate = LocalDate.now();
        String doj = employee.getDoj();
        long monthsWorked = ChronoUnit.MONTHS.between(LocalDateTime.parse(doj), currentDate);
        return monthsWorked * (employee.getSalary());

    }

    public static double calculateTaxAmount(double totalSalary) {
        double taxAmount = 0;

        if (totalSalary <= EMPLOYEE_BASE_AMOUNT) {
            taxAmount = 0;
        } else if (totalSalary <= EMPLOYEE_MIN_AMOUNT) {
            taxAmount = (totalSalary - EMPLOYEE_BASE_AMOUNT) * 0.05;
        } else if (totalSalary <= EMPLOYEE_MAX_AMOUNT) {
            taxAmount = 12500 + (totalSalary - EMPLOYEE_MIN_AMOUNT) * 0.10;
        } else {
            taxAmount = 37500 + (totalSalary - EMPLOYEE_MAX_AMOUNT) * 0.20;
        }

        return taxAmount;
    }


    public static double calculateCessAmount(double totalSalary) {
        double cessAmount = 0;
        if (totalSalary > 2500000) {
            cessAmount = (totalSalary - 2500000) * 0.02;
        }
        return cessAmount;
    }
}
