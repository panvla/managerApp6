package com.vladimirpandurov.managerApp6B.repository;

import com.vladimirpandurov.managerApp6B.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    void deleteEmployeesById(Long id);

    Optional<Employee> findEmployeeById(Long id);

}
