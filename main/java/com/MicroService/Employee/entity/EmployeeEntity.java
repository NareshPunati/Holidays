package com.MicroService.Employee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String employeeId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Long phoneNo;
    @Column
    private String designation;
    @Column
    private Float salary;
    @Column
    private Long remainingHolidays;
    @Column
    private long takenLeaves;

//    @JsonManagedReference
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "employeeEntity")
//    private List<HolidayEntity> holidays;
}
