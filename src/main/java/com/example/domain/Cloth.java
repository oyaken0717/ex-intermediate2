package com.example.domain;

import java.util.List;

public class Cloth {

	private Integer id;
	private String category;
	private String genre;

	private List<Integer> genderList;
	private List<String> colorList;
	private Integer price;
	private String size;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public List<Integer> getGenderList() {
		return genderList;
	}
	public void setGenderList(List<Integer> genderList) {
		this.genderList = genderList;
	}
	public List<String> getColorList() {
		return colorList;
	}
	public void setColorList(List<String> colorList) {
		this.colorList = colorList;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
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
		return "Cloth [id=" + id + ", category=" + category + ", genre=" + genre + ", genderList=" + genderList
				+ ", colorList=" + colorList + ", price=" + price + ", size=" + size + "]";
	}

	
}
