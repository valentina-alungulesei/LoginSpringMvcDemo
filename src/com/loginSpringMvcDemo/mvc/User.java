package com.loginSpringMvcDemo.mvc;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	private final String required = "This field is required";
	
	@NotNull(message = required)
	@Size(min = 2, message = "The name must have at least 2 characters!")
	@Pattern(regexp = "^[a-zA-z]+", message = "Only letters allowed!")
	private String firstName;
	
	@NotNull(message = required)
	@Size(min = 2, message = "The name must have at least 2 characters!")
	@Pattern(regexp = "^[a-zA-z]+", message = "Only letters allowed!")
	private String lastName;
	
	@NotNull(message = required)
	@Min(value = 18, message = "You should have at least 18 years old!")
	private Integer age;
	
	private char gender;
	
	private String country;
	
	@NotNull(message = required)
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
			 message = "The email shoud look like: name.surname@example.com")
	private String email;
	
	@NotNull(message = required)
	private String password;
	
	
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
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
