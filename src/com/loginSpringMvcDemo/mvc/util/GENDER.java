package com.loginSpringMvcDemo.mvc.util;

public enum GENDER {
	
	M("male"),
	FEMALE("female");
	
	private String gender;
	
	GENDER(String gender) {
		this.gender = gender;
	}

	public String getGenderValue() {
		return gender;
	}
}
