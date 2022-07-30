package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
    @Query(value = "select  * from employee_payroll, employee_department where employee_id = id and department = :department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);

    @Query(value = "select * from employee_payroll where salary = :salary", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesBySalary(long salary);

    @Query(value = "select * from employee_payroll where gender = :gender", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByGender(String gender);

    @Query(value = "select * from employee_payroll where startDate = :startDate", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByStartDate(LocalDate startDate);
}