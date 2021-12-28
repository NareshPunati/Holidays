package com.MicroService.Employee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    @Column
    private String adminName;
    @Column
    private String adminEmail;
}
