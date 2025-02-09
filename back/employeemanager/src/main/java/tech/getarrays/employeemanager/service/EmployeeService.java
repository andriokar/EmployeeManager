package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee deleteEmployee(Long employeeId) {
        return employeeRepository.deleteEmployeeById(employeeId);
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findEmployeeById(employeeId)
                .orElseThrow(() -> new UserNotFoundException("User by id " + employeeId + " was not found"));
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
