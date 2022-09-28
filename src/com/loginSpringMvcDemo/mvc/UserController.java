package com.loginSpringMvcDemo.mvc;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Value("#{countries}")
	private Map<String, String> countries;
	
	
	/* Pre-process every String data:
	 * add an initBinder to convert trim input string, remove leading and trailing white space.
	 * If String has only white spaces then trim it to null
	 * */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);		
	}
	
	@RequestMapping("/showRegisterForm")
	public String showRegisterForm(Model model) {
		
		// create new user object
		User user = new User();
		
		model.addAttribute("user", user);
		model.addAttribute("countries", countries);
		
		return "register-form";
	}
	
	@RequestMapping("/processForm")
	public String processRegisterForm(
									  @Valid @ModelAttribute("user") User user,
									  BindingResult bindingResult) {
		// for debugging
		System.out.println("UserController >> Binding result: " + bindingResult + "\n\n");
		
		if (bindingResult.hasErrors()) {
			return "register-form";
		}
		else {
			// capitalize names
			user.setFirstName(getCapitalizedName(user.getFirstName()));
			user.setLastName(getCapitalizedName(user.getLastName()));
			System.out.println("First name: " + user.getFirstName() 
							 + "\nLast name: " + user.getLastName()
							 + "\nAge: " + user.getAge()
							 + "\nEmail: " + user.getEmail());
			
			return "login-form";
		}
	}
	
	@RequestMapping("/showLoginForm")
	public String showLoginForm(Model model) {
		
		model.getAttribute("user");
		return "login-form";
	}
	
	private String getCapitalizedName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
