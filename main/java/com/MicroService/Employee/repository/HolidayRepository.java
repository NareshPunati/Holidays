package com.MicroService.Employee.repository;

import com.MicroService.Employee.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HolidayRepository extends JpaRepository<HolidayEntity, Integer> {

    List<HolidayEntity> findAllByEmployeeId(String id);

//    List<HolidayEntity> findAllById(String employeeId);
}
