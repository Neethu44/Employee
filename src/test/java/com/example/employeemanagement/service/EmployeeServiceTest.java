package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    public void testSave() {
        Employee testEmployee = createEmployee();
        Employee savedEmployee = createEmployeeWithId();
        Mockito.when(employeeRepository.save(testEmployee)).thenReturn(savedEmployee);
        Employee result = employeeRepository.save(testEmployee);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    public void testGetById_Success(){
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(createEmployee()));
        Employee result = employeeService.getEmployeeById(1L);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetById_Failure(){
        Mockito.when(employeeRepository.findById(0L)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {employeeService.getEmployeeById(0L);
        });
    }

    private Employee createEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Test");
        employee.setDepartment("Test Department");
        employee.setSalary(100.00);
        return employee;
    }

    private Employee createEmployeeWithId() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setEmployeeName("Test");
        employee.setDepartment("Test Department");
        employee.setSalary(100.00);
        return employee;
    }
}
