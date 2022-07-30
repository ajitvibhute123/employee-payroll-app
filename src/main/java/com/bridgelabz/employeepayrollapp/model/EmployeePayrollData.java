package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

public @Data class EmployeePayrollData {
    private int employeeID;
    private  String name;
    private  Long salary;
    public String gender;
   // @JsonFormat(pattern = "dd MMM yyyy")
   // public LocalDate startDate;
    @JsonFormat(pattern = "dd MMM yyyy")
    public LocalDate startDate;
    public String note;
    public String profilePic;
    private List<String> department;

    public EmployeePayrollData() {}

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeID = empId;
        this.name = employeePayrollDTO.name ;
        this.salary= employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;

    }
}