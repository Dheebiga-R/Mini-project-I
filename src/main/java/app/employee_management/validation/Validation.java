package app.employee_management.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//handling exceptions
@ControllerAdvice
public class Validation extends ResponseEntityExceptionHandler{
	
	//any exceptions occur it will get that error and display the error message and field to the user in understandable way
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, String> response = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldname = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldname, message);
			});
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}

	//custom exception to handle user id present or not
	@ExceptionHandler(EmployeeIdNotPresent.class)
	public ResponseEntity<Map<String, String>> employeeIdNotPresent(EmployeeIdNotPresent exception) {
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("message",exception.getMessage());
		return new ResponseEntity<Map<String,String>>(responseMap,HttpStatus.NOT_FOUND);
	}
}
