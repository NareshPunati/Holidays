package com.MicroService.Employee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "publicHolidays")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublicHolidayEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String date;
    @Column
    private String description;
}
