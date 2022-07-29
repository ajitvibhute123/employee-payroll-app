package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    
    /* UC- 1-Introducing DTO and Model to Employee Payroll App - Note that we have kept the DTO and*/

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Krunali", 50000L));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful" ,employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData employeePayrollData=null;
        employeePayrollData=new EmployeePayrollData(1, new EmployeePayrollDTO("Krunali", 50000L));
        ResponseDTO respDTO=new ResponseDTO("Get Call For ID Successful", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
        public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
            EmployeePayrollData employeePayrollData = null;
            employeePayrollData = new EmployeePayrollData(1, empPayrollDTO);
            ResponseDTO respDTO = new ResponseDTO("Created employee Payroll data successfully", employeePayrollData);
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated employee Payroll data successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respDTO = new ResponseDTO("Deleted successfully","Deleted id: "+empId);
        return new  ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
    
}