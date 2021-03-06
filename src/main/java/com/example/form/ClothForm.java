package com.example.form;

import javax.validation.constraints.NotBlank;

/**
 * 検索画面からのリクエストパラメータを受け取る.
 * 
 * @author oyamadakenji
 *
 */
public class ClothForm {
	
	/** ID */
	private String id;
	/** カテゴリー */
	private String category;
	/** ジャンル */
	private String genre;
	/** 性別 */
	@NotBlank(message="入力ミスがあります。")
	private String gender;
	/** 色 */
	private String color;
	/** 価格 */
	private String price;
	/** サイズ */
	private String size;
	
	public Integer getIntId() {
		return Integer.parseInt(id);
	}
	public Integer getIntGender() {
		return Integer.parseInt(gender);
	}
	public Integer getIntPrice() {
		return Integer.parseInt(price);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "ClothForm [id=" + id + ", category=" + category + ", genre=" + genre + ", gender=" + gender + ", color="
				+ color + ", price=" + price + ", size=" + size + "]";
	}
	
	
}
