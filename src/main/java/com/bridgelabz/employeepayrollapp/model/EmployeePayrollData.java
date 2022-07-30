package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

public @Data class EmployeePayrollData {
    private int employeeID;
    private  String name;
    private  Long Salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    private List<String> department;

    public EmployeePayrollData() {}

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeID = empId;
        this.name = employeePayrollDTO.name ;
        this.Salary= employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;

    }
}