package com.purington.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/submit")
	public String submitForm(
			@RequestParam(value = "number") Integer number,
			@RequestParam(value = "city") String city,
			@RequestParam(value = "person") String person,
			@RequestParam(value = "hobby") String hobby,
			@RequestParam(value = "living") String living,
			@RequestParam(value = "message") String message,
			HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("message", message);
		
		return "redirect:/omikuji";
	}
	
	@RequestMapping("/omikuji")
	public String omikuji(HttpSession session, Model model) {
		if(session.getAttribute("number") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("number", session.getAttribute("number"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("hobby", session.getAttribute("hobby"));
		model.addAttribute("living", session.getAttribute("living"));
		model.addAttribute("message", session.getAttribute("message"));
		
		return "omikuji.jsp";
		
	}
}
