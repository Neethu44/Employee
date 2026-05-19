package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
       return  employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
