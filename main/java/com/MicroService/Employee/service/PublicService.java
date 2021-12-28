package com.MicroService.Employee.service;

import com.MicroService.Employee.entity.PublicHolidayEntity;
import com.MicroService.Employee.model.PublicHolidayModel;
import com.MicroService.Employee.repository.PublicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequestMapping("/publicHolidays")
public class PublicService {

    @Autowired
    private PublicRepository publicRepository;

    public PublicHolidayEntity addPublicHoliday(PublicHolidayModel ph){

        PublicHolidayEntity publicHolidayEntity = new PublicHolidayEntity();
        publicHolidayEntity.setId(ph.getId());
        publicHolidayEntity.setDate(ph.getDate());
        publicHolidayEntity.setDescription(ph.getDescription());

        return publicRepository.save(publicHolidayEntity);
    }

    public PublicHolidayModel getPublicHolidayModel(PublicHolidayEntity publicHoliday){

        PublicHolidayModel publicHolidayModel = new PublicHolidayModel();
        publicHolidayModel.setId(publicHoliday.getId());
        publicHolidayModel.setDate(publicHoliday.getDate());
        publicHolidayModel.setDescription(publicHoliday.getDescription());

        return publicHolidayModel;
    }

    public List<PublicHolidayModel> getPublicHolidays(){
        List<PublicHolidayEntity> publicHolidayEntities = publicRepository.findAll();
     return publicHolidayEntities.stream().map(p -> getPublicHolidayModel(p))
                .collect(Collectors.toList());
    }

    public void deleteById(String id){
     Optional<PublicHolidayEntity> first = publicRepository.findById(id).stream().findFirst();
     first.ifPresent(f -> publicRepository.deleteById(id));
    }

}
