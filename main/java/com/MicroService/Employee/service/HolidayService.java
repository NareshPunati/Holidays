package com.MicroService.Employee.service;

import com.MicroService.Employee.entity.HolidayEntity;
import com.MicroService.Employee.model.HolidayModel;
import com.MicroService.Employee.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequestMapping("/holidays")
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public HolidayEntity addHoliday(HolidayModel holiday ,String employeeId){

        HolidayEntity holidayEntity = new HolidayEntity();
        holidayEntity.setEmployeeId(employeeId);
        holidayEntity.setFromDate(holiday.getFromDate());
        holidayEntity.setToDate(holiday.getToDate());
        holidayEntity.setDescription(holiday.getDescription());
        holidayEntity.setHalfDay(holiday.isHalfDay());
        if(holidayEntity.isHalfDay() == true){
            holidayEntity.setDays(0.5);
        }else {
            Double days = Double.valueOf(ChronoUnit.DAYS.between(holiday.getFromDate(),holiday.getToDate()));
            holidayEntity.setDays(days+1);
        }
        holidayEntity.setStatus(holiday.getStatus());

       return holidayRepository.save(holidayEntity);
    }
    public HolidayModel getHolidayModel(HolidayEntity holidayEntity){

        HolidayModel holidayModel = new HolidayModel();
        holidayModel.setHolidayId(holidayEntity.getHolidayId());
        holidayModel.setEmployeeId(holidayEntity.getEmployeeId());
        holidayModel.setToDate(holidayEntity.getToDate());
        holidayModel.setFromDate(holidayEntity.getFromDate());
        holidayModel.setDescription(holidayEntity.getDescription());
        holidayModel.setDays(holidayEntity.getDays());
        holidayModel.setHalfDay(holidayEntity.isHalfDay());
        holidayModel.setStatus(holidayEntity.getStatus());

        return holidayModel;
    }
    public List<HolidayModel> getById(String id){
        List<HolidayEntity> holiday = holidayRepository.findAllByEmployeeId(id);
       List<HolidayModel> holidaysModel= holiday.stream().map(h -> getHolidayModel(h)).collect(Collectors.toList());

       if ( holidaysModel != null){
           return holidaysModel;
       }else{
           return null;
       }
    }

    public List<HolidayModel> getAllEmployeeHolidays(){
        List<HolidayEntity> holidayEntities = holidayRepository.findAll();
       return holidayEntities.stream().map(h -> getHolidayModel(h)).collect(Collectors.toList());
    }
}
