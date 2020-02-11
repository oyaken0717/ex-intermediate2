package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チーム関連の業務処理を行う.
 * 
 * @author oyamadakenji
 *
 */
@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository; 
	
	/**
	 * チーム情報を全件取得する.
	 * 
	 * @return チーム情報の入ったリスト
	 */
	public List<Team> showList() {
		List<Team> teamList =  teamRepository.findAll();
		return teamList;
	}
	
	/**
	 * 1チームの情報を取得する.
	 * 
	 * @param id
	 * @return 1チームの情報の入ったオブジェクト
	 */
	public Team showDetail(Integer id) {
		Team team = teamRepository.load(id);
		return team;
	}
	
	
}
