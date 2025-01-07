package app.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.employee_management.model.Employee;
import app.employee_management.service.EmployeeService;
import app.employee_management.validation.EmployeeIdNotPresent;
import jakarta.validation.Valid;

//controller layer which get the request from the user, processing the requests and response
@Controller
public class EmployeeController {

	//Get the requests and automatically connect it to the service layer
	@Autowired
	private EmployeeService employeeService;
	
	//request to show list of employees
	@GetMapping("/employees")
	public String getEmployees(Model model){
	    model.addAttribute("employees", this.employeeService.getAllEmployee());
	    return "display";
	}
	
	//request to save employee detail
	@GetMapping("/employee")
	public String saveEmployee(Employee employee,Model model) {
		model.addAttribute("employee", new Employee());
		return "add";
	}
	
	//request for processing the user input and validate it
	@PostMapping("/process")
	public String processData(@Valid Employee employee,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "add";
		}
		this.employeeService.addEmployee(employee);
		return "redirect:employees";
	}
	
	//request for deleting the user detail
	@RequestMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		this.employeeService.deleteEmpById(id);
		return "redirect:/employees";
	}
	
	//request to view the user detail
	@GetMapping("/view/{id}")
	public String viewEmployeeById(@PathVariable("id") Long id,Model model) throws EmployeeIdNotPresent {
		Employee existEmployee = this.employeeService.getEmployeeById(id);
		model.addAttribute("employee", existEmployee);
		return "view";
	}
	
	//request for update the user detail
	@GetMapping("/update/{id}")
	public String updateEmployeeById(@PathVariable("id") Long id,Model model) throws EmployeeIdNotPresent {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		return "update";
	}
	
	//processing the update information and set the updated value
	@PostMapping("/process/{id}")
	public String updateEmployee(@PathVariable("id") Long id,@Valid@ModelAttribute("employee")Employee employee,BindingResult result,Model model) throws EmployeeIdNotPresent {
		if(result.hasErrors()) {
			return "update";
		}
		Employee existingEmployee = this.employeeService.getEmployeeById(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmailId(employee.getEmailId());
		this.employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";
	}
	
}
