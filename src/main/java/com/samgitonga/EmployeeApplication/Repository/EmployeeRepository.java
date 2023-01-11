package com.samgitonga.EmployeeApplication.Repository;

import com.samgitonga.EmployeeApplication.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
