package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.ElementCollection;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
//@Entity Annotation tells Hibernate to create a table out of the Employee Payroll Class
@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeID;

    @Column(name = "name")
    private  String name;
    @Column(name = "Salary")
    private  Long Salary;
    @Column(name = "gender")
    public String gender;
    @Column(name = "Start_Date")
    public LocalDate startDate;
    @Column(name = "note")
    public String note;
    @Column(name = "profile_Pic")
    public String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;
    public EmployeePayrollData() {}

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name ;
        this.Salary= employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;

    }
}