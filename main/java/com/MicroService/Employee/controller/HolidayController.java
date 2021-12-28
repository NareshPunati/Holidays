package com.MicroService.Employee.controller;

import com.MicroService.Employee.entity.HolidayEntity;
import com.MicroService.Employee.model.HolidayModel;
import com.MicroService.Employee.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holiday")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @PostMapping("/add/{employeeId}")
    public HolidayEntity addHoliday(@RequestBody HolidayModel holidayModel, @PathVariable String employeeId) {
        return holidayService.addHoliday(holidayModel,employeeId);
    }
    @GetMapping("/get/{id}")
    public List<HolidayModel> getById(@PathVariable String id){
        return holidayService.getById(id);
    }

    @GetMapping("get-all/holidays")
    public List<HolidayModel> getAllEmployeeHolidays(){
        return holidayService.getAllEmployeeHolidays();
    }
}
