package com.MicroService.Employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel {

    private int adminId;
    private String adminName;
    private String adminEmail;

}
