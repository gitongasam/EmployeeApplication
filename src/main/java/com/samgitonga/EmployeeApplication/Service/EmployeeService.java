package com.samgitonga.EmployeeApplication.Service;

import com.samgitonga.EmployeeApplication.Entity.Employee;
import com.samgitonga.EmployeeApplication.Exception.ResourceNotFoundException;
import com.samgitonga.EmployeeApplication.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user with Id "+ id+"not found" ));
    }
    public  Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id){
        Employee existingEmployee=this.employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id: "+id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(existingEmployee);

    }


    public ResponseEntity<Object> deleteEmployee(Long id) {
        Employee existingEmployee=this.employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id: "+id));
        this.employeeRepository.delete(existingEmployee);
        return ResponseEntity.ok().build();
    }
}
