package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル関連機能の業務処理を行う.
 * 
 * @author oyamadakenji
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * 引数で指定した価格以下のホテルの情報を探す.
	 * 
	 * @param price 価格
	 * @return ホテルの情報の入ったList型のオブジェクト
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		List<Hotel> hotelList = hotelRepository.findByPrice(price);
		return hotelList;
	}
	
	/**
	 * 価格の指定がない時にすべてのホテルの情報を取得する.
	 * 
	 * @return ホテルの情報の入ったオブジェクト
	 */
	public List<Hotel> searchByNoPrice() {
		List<Hotel> hotelList = hotelRepository.findAll();
		return hotelList;
	}
}
