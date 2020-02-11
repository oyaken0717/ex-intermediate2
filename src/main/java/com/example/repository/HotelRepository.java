package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * Hotelsテーブルの情報を操作するレポジトリ.
 * 
 * @author oyamadakenji
 *
 */
@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs,i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	/**
	 * 指定した価格以下のホテルを取得する.
	 * 
	 * @param price 価格
	 * @return ホテルの情報の入ったリスト
	 */
	public List<Hotel> findByPrice(Integer price) {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price";
		SqlParameterSource param = new MapSqlParameterSource("price",price);
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}
	
	/**
	 * 全ホテルの情報を取得する.
	 * 
	 * @return 全ホテルの情報が入ったリスト
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels";
		List<Hotel> hotelList = template.query(sql,HOTEL_ROW_MAPPER);
		return hotelList;
	}
}
