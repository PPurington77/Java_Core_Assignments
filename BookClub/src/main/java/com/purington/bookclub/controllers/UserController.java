package com.purington.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.purington.bookclub.models.LoginUser;
import com.purington.bookclub.models.User;
import com.purington.bookclub.services.BookService;
import com.purington.bookclub.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	//Display
	@RequestMapping("/")
	public String index() {
		return "redirect:/user/login";
	}
	
	//Display login page
	@GetMapping("/user/login")
	public String loginOrRegistration(Model model, HttpSession session) {
		
		//checks if user is already logged in
		if(session.getAttribute("uuid") != null) {
			return "redirect:/user/shelves";
		}
		
		//Bind empty User and LoginUser objects to the JSP 
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}
	
	//Action for registering a user
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		
		User user = userService.register(newUser, result);
		
		//check for errors with registration, bind new login user, and redirect to show errors
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			
			return "index.jsp";
		}
		
		//if no errors create user session and redirect to shelves
		session.setAttribute("uuid", user.getId());
		
		return "redirect:/user/shelves";
	}
	
	//Action for logging in a user
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		
		//creates user object
		User user = userService.login(newLogin, result);
		
		//checks for errors w/ login, binds new user, and redirects to show errors
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			
			return "index.jsp";
		}
		
		//if no errors login user, create user session, and redirect to shelves
		session.setAttribute("uuid", user.getId());
		
		return "redirect:/user/shelves";
	}
	
	//logs out user
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uuid");
		
		return "redirect:/";
	}
	
	//displays the User Shelf/dashboard
	@GetMapping("/user/shelves")
	public String shelves(HttpSession session, Model model) {
		
		//checks if there is a user is in session and redirects if not
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		Long userId = (Long) session.getAttribute("uuid");
		model.addAttribute("user", userService.getOne(userId));
		model.addAttribute("book", bookService.allBooks());
		
		return "shelves.jsp";
	}
	
}
