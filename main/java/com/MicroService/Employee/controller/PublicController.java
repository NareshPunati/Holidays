package com.MicroService.Employee.controller;

import com.MicroService.Employee.entity.PublicHolidayEntity;
import com.MicroService.Employee.model.PublicHolidayModel;
import com.MicroService.Employee.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicHoliday")
public class PublicController {

    @Autowired
    private PublicService publicService;

    @PostMapping("/add")
    public PublicHolidayEntity addPublicHolidays(@RequestBody PublicHolidayModel publicHolidayModel){
        return publicService.addPublicHoliday(publicHolidayModel);
    }
    @GetMapping("/get-all")
    public List<PublicHolidayModel> getPublicHolidays(){
        return publicService.getPublicHolidays();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(String id){
        publicService.deleteById(id);
    }
}
