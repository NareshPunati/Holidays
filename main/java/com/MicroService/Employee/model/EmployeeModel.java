package com.MicroService.Employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

    private String employeeId;
    private String name;
    private String email;
    private Long phoneNo;
    private String designation;
    private Float salary;
    private Long remainingHolidays;
    private long takenLeaves;
//    private List<HolidayModel> holidayModels;
}
