package app.employee_management.service;

import java.util.List;

import app.employee_management.model.Employee;
import app.employee_management.validation.EmployeeIdNotPresent;
import jakarta.validation.Valid;

//service layer interface which contains all the abstract methods to processing the user data
public interface EmployeeService {

	//method for add the new employee detail
	Employee addEmployee(Employee employee);
	
	//method for delete the employee by id
	void deleteEmpById(Long id);
	
	//method for get all the employee details
	List<Employee> getAllEmployee();
	
	//method for get the employee by id, if id doesn't match with 
	//all it will show custom validation exception
	Employee getEmployeeById(Long id) throws EmployeeIdNotPresent;
	
	//method used to update the employee detail
	Employee updateEmployee(Employee employee);
}
