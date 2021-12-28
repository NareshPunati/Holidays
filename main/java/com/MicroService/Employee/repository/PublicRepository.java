package com.MicroService.Employee.repository;

import com.MicroService.Employee.entity.PublicHolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicRepository extends JpaRepository<PublicHolidayEntity, String> {
}
