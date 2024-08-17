package app.employee_management.service;

import java.util.List;

import app.employee_management.model.Employee;
import app.employee_management.validation.EmployeeIdNotPresent;
import jakarta.validation.Valid;

public interface EmployeeService {

	Employee addEmployee(Employee employee);
	void deleteEmpById(Long id);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(Long id) throws EmployeeIdNotPresent;
	Employee updateEmployee(Employee employee);
}
