package com.vladimirpandurov.managerApp6B.service;

import com.vladimirpandurov.managerApp6B.exception.EmployeeNotFoundException;
import com.vladimirpandurov.managerApp6B.model.Employee;
import com.vladimirpandurov.managerApp6B.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id){
        return this.employeeRepository.findEmployeeById(id).orElseThrow(()-> new EmployeeNotFoundException("User with id " + " not found"));
    }

    public List<Employee> findAllEmployees(){
        return this.employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
         this.employeeRepository.deleteEmployeesById(employeeId);
    }

}
