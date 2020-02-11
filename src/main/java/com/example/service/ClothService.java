package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 衣服の処理の業務処理をする.
 * 
 * @author oyamadakenji
 *
 */
@Service
@Transactional
public class ClothService {

	@Autowired
	private ClothRepository clothRepository;
	
	/**
	 * 引数に入った性別と色の情報から衣服の情報を取得する.
	 * 
	 * @param cloth
	 * @return 衣服の情報が入ったList型のオブジェクト
	 */
	public List<Cloth> search(Cloth cloth) {
		List<Cloth> clothList = clothRepository.findByGenderAndcolor(cloth.getGender(), cloth.getColor());
		return clothList;
	}	
}
