package com.javaweb.model;
// contain data to show to client
public class BuildingDTO {
	private String name;
	private Integer numberOfBasement;
	private String address;
	private String nameManager;
	private String numberPhoneManager;
	private String areaFloor;
	private String areaRent;
	private String brokerageFee;
	private String priceRent;
	private String serviceFee;
	private String remainArea;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNameManager() {
		return nameManager;
	}
	public void setNameManager(String nameManager) {
		this.nameManager = nameManager;
	}
	public String getNumberPhoneManager() {
		return numberPhoneManager;
	}
	public void setNumberPhoneManager(String numberPhoneManager) {
		this.numberPhoneManager = numberPhoneManager;
	}
	public String getAreaFloor() {
		return areaFloor;
	}
	public void setAreaFloor(String areaFloor) {
		this.areaFloor = areaFloor;
	}
	public String getAreaRent() {
		return areaRent;
	}
	public void setAreaRent(String areaRent) {
		this.areaRent = areaRent;
	}
	public String getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(String brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	public String getPriceRent() {
		return priceRent;
	}
	public void setPriceRent(String priceRent) {
		this.priceRent = priceRent;
	}
	public String getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}
	public String getRemainArea() {
		return remainArea;
	}
	public void setRemainArea(String remainArea) {
		this.remainArea = remainArea;
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
	
}
