package com.example.form;

import org.hibernate.validator.constraints.Range;

/**
 * 検索時に使用するフォーム.
 * 
 * @author oyamadakenji
 *
 */
public class HotelForm {

	/** ID */
	private String id;
	/** エリアネーム */
	private String areaName;
	/** ホテル名 */
	private String hotelName;
	/** 住所 */
	private String address;
	/** 最寄駅 */
	private String nearestStation;
	/** 価格 */
    @Range(max = 20000, message ="2万1円以上の価格のホテルはございません。")
	private String price;
    /** 駐車場 */
	private String parking;
	
	public Integer getIntPrice() {
		return Integer.parseInt(price);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNearestStation() {
		return nearestStation;
	}
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	@Override
	public String toString() {
		return "HotelForm [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", address=" + address
				+ ", nearestStation=" + nearestStation + ", price=" + price + ", parking=" + parking + "]";
	}
}
