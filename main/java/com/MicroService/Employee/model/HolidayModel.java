package com.MicroService.Employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HolidayModel {

    private int holidayId;
    private String EmployeeId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private boolean halfDay;
    private String description;
    private Double days;
    private String status;

}
