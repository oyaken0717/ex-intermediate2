package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

@Controller
@RequestMapping("hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("receive-form")
	public String searchByLessThanPrice(Integer price, Model model) {
		if (price == null) {
			List<Hotel> hotelList = hotelService.searchByNoPrice();			
			model.addAttribute("hotelList", hotelList);
		}else {
			List<Hotel> hotelList = hotelService.searchByLessThanPrice(price);			
			model.addAttribute("hotelList", hotelList);
		}
		return "index";
	}
	
}
