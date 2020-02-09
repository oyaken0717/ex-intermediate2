package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cloth")
public class ClothController {

	@RequestMapping("")
	public String index(){
		
		
		return "cloth/index";
	}
	
	@RequestMapping("receive-form")
	public String receiveForm(String drone,String huey){
		System.out.println(drone);
		System.out.println(huey);
		return "cloth/result";
	}
	
}
