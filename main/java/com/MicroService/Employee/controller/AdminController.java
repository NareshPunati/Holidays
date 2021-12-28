package com.MicroService.Employee.controller;

import com.MicroService.Employee.entity.AdminEntity;
import com.MicroService.Employee.model.AdminModel;
import com.MicroService.Employee.model.HolidayModel;
import com.MicroService.Employee.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/holiday-approval/{status}")
    public HolidayModel holidayApproval(@RequestHeader int holidayId, @PathVariable String status){
       return adminService.holidayApproval(holidayId,status);
    }

    @PostMapping("/add")
    public AdminEntity addAdmin(@RequestBody AdminModel admin) {
        return adminService.addAdmin(admin);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        adminService.deleteById(id);
    }
}
