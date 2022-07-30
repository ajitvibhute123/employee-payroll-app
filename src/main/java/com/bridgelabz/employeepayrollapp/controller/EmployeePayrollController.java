package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
    
    /* UC-1Use Lombok Library to auto generate getters and setters for the DTO*/
@Autowired
 private IEmployeePayrollService employeePayrollService;
    /**
     * Method :- Method to Get the Employee Payroll Data.
     * return :- Returning ResponseDTO Object.
     */
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful" ,employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    /**
     * Method :- Method to Get the Employee Payroll Data Using Employee ID.
     * param employeeId :- passing Employee Id As Input
     * return :- Returning ResponseDTO Object.
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO=new ResponseDTO("Get Call For ID Successful", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    /**
     * Method :- Method to Create the Employee Payroll Data.
     * param employeePayrollDTO :- passing employeePayrollDTO As Input.
     * return :-  Returning ResponseDTO Object.
     */
    // Added Log,debug for the remaining properties
    @PostMapping("/create")
        public ResponseEntity<ResponseDTO> addEmployeePayrollData(
                                          @Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        log.debug("Employee DTO: "+empPayrollDTO.toString());
        EmployeePayrollData employeePayrollData =employeePayrollService.createEmployeePayrollData(empPayrollDTO);
            ResponseDTO respDTO = new ResponseDTO("Created employee Payroll data successfully", employeePayrollData);
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    /**
     * Method :- Method to Update the Employee Payroll Data.
     * param employeePayrollDTO :- passing employeePayrollDTO As Input.
     * return :-  Returning ResponseDTO Object.
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
                                         @Valid @PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData =employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated employee Payroll data successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    /**
     * Method :- Method to Delete the Employee Payroll Data.
     * param empId :- passing Employee Id As Input.
     * return Returning ResponseDTO Object.
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted successfully","Deleted id: "+empId);
        return new  ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
    
}