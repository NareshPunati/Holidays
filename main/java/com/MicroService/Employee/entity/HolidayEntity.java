package com.MicroService.Employee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "holiday")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HolidayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int holidayId;
    @Column
    private String employeeId;
    @Column
    private LocalDate fromDate;
    @Column
    private LocalDate toDate;
    @Column
    private String description;
    @Column
    private boolean halfDay;
    @Column
    private Double days;
    @Column
    private String status;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "employeeId") //, name="id"
//    private EmployeeEntity employeeEntity;
}
