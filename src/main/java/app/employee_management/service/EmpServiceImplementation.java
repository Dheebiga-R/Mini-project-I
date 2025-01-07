package app.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.employee_management.model.Employee;
import app.employee_management.repository.EmployeeRepository;
import app.employee_management.validation.EmployeeIdNotPresent;

//implementation of all methods from service interface
@Service
public class EmpServiceImplementation implements EmployeeService{

	//to connect repository layer to get the default methods to perform some operations on data
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmpById(Long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) throws EmployeeIdNotPresent {
		return this.employeeRepository.findById(id).orElseThrow(()->new EmployeeIdNotPresent("Employee Id Not Present"));
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

}
