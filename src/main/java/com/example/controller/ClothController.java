package com.example.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.form.ClothForm;
import com.example.service.ClothService;

/**
 * 衣服情報関連の処理を制御するコントローラー.
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {

	@Autowired
	private ClothService ClothService;

	/**
	 * 検索画面からきたリクエストパラメータを受け止める.
	 * 
	 * @return リクエストパラメータの情報が格納されたオブジェクト
	 */
	@ModelAttribute
	public ClothForm setUpClothForm() {
		return new ClothForm();
	}
	
	/**
	 * 衣服検索画面に遷移する.
	 * 
	 * @return 衣服検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "cloth/index";
	}

	/**
	 * 受け取ったリクエストパラメータから衣服の情報を取得し検索画面に戻る.
	 * 
	 * @param form 検索画面からきたリクエストパラメータを受け取る
	 * @param result エラー情報を受け取る
	 * @param model 露クエストパラメータ
	 * @return 衣服検索画面
	 */
	@RequestMapping("receive-form")
	public String receiveForm(@Validated ClothForm form,BindingResult result,Model model) {

		if (result.hasErrors()) {
			return index();
		}
		
		Cloth cloth = new Cloth();
		cloth.setGender(form.getIntGender());
		BeanUtils.copyProperties(form, cloth);
		
		List<Cloth> clothList = ClothService.search(cloth);
		model.addAttribute("clothList",clothList);
		
		return "cloth/index";
	}
}
