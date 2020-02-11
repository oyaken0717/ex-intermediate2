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

/**
 * ホテル関連の処理の制御をするコントローラー.
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	/**
	 * ホテルを検索する際のリクエストパラメータが格納される.
	 * 
	 * @return リクエストパラメータの入ったオブジェクト
	 */
	@ModelAttribute
	public HotelForm setUpHotelForm() {
		return new HotelForm();
	}

	/**
	 * ホテル検索画面に遷移する.
	 * 
	 * @return ホテル検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "hotel/index";
	}

	/**
	 * ホテルの情報を検索する.
	 * 
	 * @param form 検索画面からのリクエストパラメータを受け取る
	 * @param result エラー情報を格納する
	 * @param model リクエストパラメータ
	 * @return ホテル検索画面
	 */
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
