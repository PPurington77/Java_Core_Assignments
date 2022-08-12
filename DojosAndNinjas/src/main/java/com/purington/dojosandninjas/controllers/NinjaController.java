package com.purington.dojosandninjas.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.purington.dojosandninjas.models.Ninja;
import com.purington.dojosandninjas.services.DojoService;
import com.purington.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ninjaService;
	
	@Autowired DojoService dojoService;
	
	//Display
	@GetMapping("/ninja/new")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Ninja> ninjas = ninjaService.allNinjas();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojos", dojoService.allDojos());
		
		return "ninjas.jsp";
	}
	
	//Action = Create Ninja//
	@PostMapping("/create/ninja")
	public String Ninja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("ninjas", ninjaService.allNinjas());
			model.addAttribute("dojos", dojoService.allDojos());
			return "ninjas.jsp";
		}
		else ninjaService.createNinja(ninja);
		return "redirect:/dojos";
	}
}
