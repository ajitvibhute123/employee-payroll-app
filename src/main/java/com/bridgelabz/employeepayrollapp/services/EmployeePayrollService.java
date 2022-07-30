package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    /* UC-3 The Services Layer will store this Data in a Memory as a List.*/
    private List<EmployeePayrollData> employeePayrollList =new ArrayList<>();
//    public EmployeeDetails createEmployeePayrollData(EmployeeDTO employeePayrollDTO) {
//        EmployeeDetails empData = new EmployeeDetails(empDataList.size()+1,employeePayrollDTO);
//        empDataList.add(empData);
//        return empData;
    //}
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                .filter(empData -> empData.getEmployeeID() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollList.size()+1, empPayrollDTO);;
       
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData ;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        employeePayrollList.set(empId-1, empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);

    }
}