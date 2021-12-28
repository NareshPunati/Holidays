package com.MicroService.Employee.service;

import com.MicroService.Employee.entity.AdminEntity;
import com.MicroService.Employee.entity.EmployeeEntity;
import com.MicroService.Employee.entity.HolidayEntity;
import com.MicroService.Employee.model.AdminModel;
import com.MicroService.Employee.model.HolidayModel;
import com.MicroService.Employee.repository.AdminRepository;
import com.MicroService.Employee.repository.EmployeeRepository;
import com.MicroService.Employee.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private HolidayRepository holidayRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public AdminEntity addAdmin(AdminModel admin){

        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setAdminId(admin.getAdminId());
        adminEntity.setAdminName(admin.getAdminName());
        adminEntity.setAdminEmail(admin.getAdminEmail());

        return adminRepository.save(adminEntity);
    }
 //< --------------------------Model to Entity--------------------------------->
    public AdminModel getAdmin(AdminEntity adminEntity){

        AdminModel adminModel = new AdminModel();
        adminModel.setAdminId(adminEntity.getAdminId());
        adminModel.setAdminName(adminEntity.getAdminName());
        adminModel.setAdminEmail(adminEntity.getAdminEmail());
        return adminModel;
    }
    public AdminModel getById(int id){
        Optional<AdminEntity> admin = adminRepository.findById(id);
        if (admin.isPresent()){
            return getAdmin(admin.get());
        }
        return null;
    }

    public HolidayModel convertToHolidayModel(HolidayEntity holidayEntity){

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

    public HolidayModel holidayApproval(int holidayId, String status) {
        Optional<HolidayEntity> holiday = holidayRepository.findById(holidayId);
        if (holiday.isPresent()) {
            Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(holiday.get().getEmployeeId());

            if (! holiday.get().getStatus().equals("accept") && status.equals("accept") ) {
                holiday.get().setStatus(status);

            employeeEntity.get().setRemainingHolidays((long) (employeeEntity.get().getRemainingHolidays()
                    - holiday.get().getDays()));
            employeeEntity.get().setTakenLeaves((long) (employeeEntity.get().getTakenLeaves() + holiday.get().getDays()));
            }
            else if (status.equals("reject")){
                holiday.get().setStatus(status);
            }
            employeeRepository.save(employeeEntity.get());
        }
        holidayRepository.save(holiday.get());

        return convertToHolidayModel(holiday.get());
    }
    public void deleteById(int id){
        Optional<AdminEntity> first = adminRepository.findById(id).stream().filter(a ->
                a.getAdminId() == id).findFirst();
        first.ifPresent(f -> adminRepository.deleteById(id));
    }
}
