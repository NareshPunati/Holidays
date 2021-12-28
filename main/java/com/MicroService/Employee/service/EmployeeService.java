package com.MicroService.Employee.service;

import com.MicroService.Employee.entity.EmployeeEntity;
import com.MicroService.Employee.model.EmployeeModel;
import com.MicroService.Employee.repository.EmployeeRepository;
import com.MicroService.Employee.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private HolidayRepository holidayRepository;

    public EmployeeEntity addEmployee(EmployeeModel employeeModel) {

        EmployeeEntity employeeEntity = new EmployeeEntity();

//        List<HolidayEntity> holidayEntities = new ArrayList<>();
//        employeeModel.getHolidayModels().forEach(h -> {
//        HolidayEntity holidayEntity = new HolidayEntity();
//        holidayEntity.setFromDate(h.getFromDate());
//        holidayEntity.setToDate(h.getToDate());
//        long days = ChronoUnit.DAYS.between(h.getFromDate(),h.getToDate());
//        holidayEntity.setDescription(h.getDescription());
//        holidayEntity.setDays(days);
//        holidayEntity.setStatus(h.getStatus());
//        holidayEntity.setEmployeeEntity(employeeEntity);
//        holidayEntities.add(holidayEntity);
//        });
        employeeEntity.setEmployeeId(employeeModel.getEmployeeId());
        employeeEntity.setName(employeeModel.getName());
        employeeEntity.setEmail(employeeModel.getEmail());
        employeeEntity.setPhoneNo(employeeModel.getPhoneNo());
        employeeEntity.setDesignation(employeeModel.getDesignation());
        employeeEntity.setSalary(employeeModel.getSalary());
        employeeEntity.setTakenLeaves(employeeModel.getTakenLeaves());
        employeeEntity.setRemainingHolidays(employeeModel.getRemainingHolidays());

//        employeeEntity.setHolidays(holidayEntities);

        return employeeRepository.save(employeeEntity);
    }
    public EmployeeModel getEmployeeModel(EmployeeEntity employeeEntity){

//        List<HolidayModel> holidayModels = new ArrayList<>();
//        employeeEntity.getHolidays().forEach(h -> {
//            HolidayModel holidayModel = new HolidayModel();
//
//            holidayModel.setFromDate(h.getFromDate());
//            holidayModel.setToDate(h.getToDate());
//            holidayModel.setDescription(h.getDescription());
//            holidayModel.setDays(h.getDays());
//            holidayModel.setStatus(h.getStatus());
//            holidayModels.add(holidayModel);
//        });
   // < -----------------------Model to Entity------------------------------------>
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setEmployeeId(employeeEntity.getEmployeeId());
        employeeModel.setName(employeeEntity.getName());
        employeeModel.setEmail(employeeEntity.getEmail());
        employeeModel.setPhoneNo(employeeEntity.getPhoneNo());
        employeeModel.setDesignation(employeeEntity.getDesignation());
        employeeModel.setSalary(employeeEntity.getSalary());
        employeeModel.setRemainingHolidays(employeeEntity.getRemainingHolidays());
        employeeModel.setTakenLeaves(employeeEntity.getTakenLeaves());
//        employeeModel.setHolidayModels(holidayModels);

        return employeeModel;
    }

    public EmployeeModel getById(String id){
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
            if (employee.isPresent()){
                return getEmployeeModel(employee.get());
            }
            return null;
        }

    public List<EmployeeModel> getEmployees(){
        List<EmployeeEntity> employees = employeeRepository.findAll();
      return employees.stream().map(e -> getEmployeeModel(e)).collect(Collectors.toList());
    }

    public void deleteById(String id){
      Optional<EmployeeEntity> first = employeeRepository.findById(id).stream().filter(e ->
              e.getEmployeeId() == id).findFirst();
      first.ifPresent(f -> employeeRepository.deleteById(id));
    }
}
