package com.loginSpringMvcDemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/showRegisterForm")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "register-form";
	}
}
