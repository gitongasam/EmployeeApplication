package com.samgitonga.EmployeeApplication.Controller;

import com.samgitonga.EmployeeApplication.Entity.Employee;
import com.samgitonga.EmployeeApplication.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping("api/v1/")
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/findById/{id}")
    public Employee findById(@PathVariable Long  id){
        return employeeService.findById(id);
    }
    @PutMapping  ("/updateEmployee/{id}")
    public  Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long  id) {
        return employeeService.updateEmployee(employee, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long  id){
        return employeeService.deleteEmployee(id);
    }
}
