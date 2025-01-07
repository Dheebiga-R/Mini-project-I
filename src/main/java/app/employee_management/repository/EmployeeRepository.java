package app.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.employee_management.model.Employee;

//repository layer used to communicate between service layer and database
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
