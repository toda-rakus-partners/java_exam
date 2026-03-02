package com.example.q8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaseballController {
	@Autowired
	private BaseballService service;
	
	@RequestMapping(value="/q8")
	public String gotoq8(Model model){
		
		List<BaseballDomain> baseballList = service.findAll();			//元data

		model.addAttribute("teams", baseballList);
		
		return "8/list";
	}
	
	

	
	
	
}
