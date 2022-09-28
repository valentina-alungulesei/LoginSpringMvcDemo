package com.loginSpringMvcDemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Value("#{countries}")
	private Map<String, String> countries;
	
	@RequestMapping("/showRegisterForm")
	public String showRegisterForm(Model model) {
		
		// create new user object
		User user = new User();
		
		model.addAttribute("user", user);
		model.addAttribute("countries", countries);
		
		return "register-form";
	}
}
