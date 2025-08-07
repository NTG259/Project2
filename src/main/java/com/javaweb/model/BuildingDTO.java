package com.javaweb.model;
// contain data to show to client
public class BuildingDTO {
	private String name;
	private Integer numberOfBasement;
	private String address;
	private Long area;
	
	public Long getArea() {
		return area;
	}
	public void setArea(Long areaLong) {
		this.area = areaLong;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
