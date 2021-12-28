package com.MicroService.Employee.controller;

import com.MicroService.Employee.entity.EmployeeEntity;
import com.MicroService.Employee.model.EmployeeModel;
import com.MicroService.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeEntity addEmployee(@RequestBody EmployeeModel employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/get/{id}")
    public EmployeeModel getById(@PathVariable String id){
        return employeeService.getById(id);
    }

    @GetMapping("get-all")
    public List<EmployeeModel> getEmployees(){
        return employeeService.getEmployees();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        employeeService.deleteById(id);
    }
}
