package app.employee_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

//employee class which contains all the fields that user need to fill
@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
public class Employee {

	//fields of employee entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name",nullable = false)
	@NotBlank(message="Fill this field")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_id",nullable = false)
	@NotBlank(message="Fill this field")
	@Email
	private String emailId;
}
