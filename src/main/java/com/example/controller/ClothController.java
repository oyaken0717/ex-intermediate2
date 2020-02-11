package com.example.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.form.ClothForm;
import com.example.service.ClothService;

@Controller
@RequestMapping("/cloth")
public class ClothController {

	@Autowired
	private ClothService ClothService;

	@RequestMapping("")
	public String index() {
		return "cloth/index";
	}

	@RequestMapping("receive-form")
	public String receiveForm(ClothForm form, Model model) {

		Cloth cloth = new Cloth();
		cloth.setGender(form.getIntGender());
		BeanUtils.copyProperties(form, cloth);
		
		List<Cloth> clothList = ClothService.search(cloth);
		model.addAttribute("clothList",clothList);
		
		return "cloth/index";
	}
}
