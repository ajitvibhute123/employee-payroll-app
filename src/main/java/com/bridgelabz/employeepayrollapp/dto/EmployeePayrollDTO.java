package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {
//UC-2 JPAR-We need to add validators to gender, startDate,note, profilePic and department
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    @NotEmpty(message = "Employee name cannot be null")
    public String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

   // @JsonFormat(pattern = "dd MMM yyyy")
   // @NotNull(message = "startDate should not be empty")
  //  @PastOrPresent(message = "startDate should be past or todays date")
   // public LocalDate startDate;
    @JsonFormat(pattern = "dd MMM yyyy")
    public LocalDate startDate;
   // @NotBlank(message = "Note should not be empty")
    public String note;

    //@NotBlank(message = "profile pic should not be empty")
    public String profilePic;

   // @NotNull(message = "department should not be empty")
    public List<String> department;

}