package com.purington.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.purington.dojosandninjas.models.Dojo;
import com.purington.dojosandninjas.services.DojoService;
import com.purington.dojosandninjas.services.NinjaService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	//Display
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos";
	}
	
	//Display
	@GetMapping("/dojos")
	public String home(@ModelAttribute("dojo") Dojo dojo, Model model) {
		
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		
		return "dojos.jsp";
	}
	
	//Action = Create Dojo//
	@PostMapping("/dojos")
	public String dojos(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "dojos.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	//Display = One Dojo and it's ninjas
	@GetMapping("view/dojo/{id}")
	public String viewDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.getDojo(id));
		
		return "viewDojo.jsp";
	}
}
