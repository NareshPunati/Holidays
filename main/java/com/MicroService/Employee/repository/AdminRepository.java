package com.MicroService.Employee.repository;

import com.MicroService.Employee.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

 //   AdminEntity findByStatus(Integer id);

//    AdminEntity findByHolidayId(int id);
}
