package com.houarizegai.springdemo.mvc.formvalidation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.houarizegai.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required (must be not empty!)")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required (must be not empty!)")
	@Min(value=0, message="Must be greater than or equal to 0!")
	@Max(value=20, message="Must be less than or equal to 20!")
	private Integer mark;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
	@CourseCode(value="CS", message="must start with CS")
	private String courseCode;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
