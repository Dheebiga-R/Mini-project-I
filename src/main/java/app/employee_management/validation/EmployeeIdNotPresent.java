package app.employee_management.validation;

//custom exception class to handle employee id
public class EmployeeIdNotPresent extends Exception{

	public EmployeeIdNotPresent(String string) {
		super(string);
	}
}
