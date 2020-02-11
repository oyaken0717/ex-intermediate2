package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * チーム関連情報の処理制御を行うコントローラー
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	/**
	 * チーム一覧画面に遷移する.
	 * 
	 * @param model リクエストスコープ
	 * @return チーム一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Team> teamList = teamService.showList();
		model.addAttribute("teamList", teamList);
		return "list";
	}
	
	/**
	 * チーム詳細画面に遷移する.
	 * 
	 * @param id ID
	 * @param model リクエストスコープ
	 * @return チーム詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id,Model model) {
		Team team = teamService.showDetail(id);
		model.addAttribute("team", team);
		return "detail";
	}
	
}
