package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@ModelAttribute
	public HotelForm setUpHotelForm() {
		return new HotelForm();
	}

	@RequestMapping("")
	public String index() {
		return "hotel/index";
	}

	@RequestMapping("receive-form")
	public String searchByLessThanPrice(@Validated HotelForm form, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return index();
		}

		Hotel hotel = new Hotel();
		hotel.setPrice(form.getIntPrice());

		if (form.getPrice() == null) {
			List<Hotel> hotelList = hotelService.searchByNoPrice();
			model.addAttribute("hotelList", hotelList);
		} else {
			List<Hotel> hotelList = hotelService.searchByLessThanPrice(hotel.getPrice());
			model.addAttribute("hotelList", hotelList);
		}
		return "hotel/index";
	}

}
