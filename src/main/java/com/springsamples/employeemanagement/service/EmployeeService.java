package com.springsamples.employeemanagement.service;

import com.springsamples.employeemanagement.employeeRepo.EmployeeRepo;
import com.springsamples.employeemanagement.exception.UserNotFoundException;
import com.springsamples.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class EmployeeService {
    
    private  final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return  employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return  employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id "+id+" was not found"));
    }

}
