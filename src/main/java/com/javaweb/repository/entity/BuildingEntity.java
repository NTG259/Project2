package com.javaweb.repository.entity;

public class BuildingEntity {
	private String name;
	private String street;
	private String ward;
	private String district;
	private Integer numberOfBasement;
	private Integer floorArea;
	private String direction;
	private Integer rentPrice;
	private String rentPriceDescription;
	private Long serviceFee;
	private Long brokerageFee;
	private Long rentArea;
	private String managerName;
	private String managerPhoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getNumberofbasement() {
		return numberOfBasement;
	}
	public void setNumberofbasement(Integer numberofbasement) {
		this.numberOfBasement = numberofbasement;
	}
	public Integer getFloorarea() {
		return floorArea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorArea = floorarea;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getRentprice() {
		return rentPrice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentPrice = rentprice;
	}
	public String getRentpricedescription() {
		return rentPriceDescription;
	}
	public void setRentpricedescription(String rentpricedescription) {
		this.rentPriceDescription = rentpricedescription;
	}
	public Long getServicefee() {
		return serviceFee;
	}
	public void setServicefee(Long servicefee) {
		this.serviceFee = servicefee;
	}
	public Long getBrokeragefee() {
		return brokerageFee;
	}
	public void setBrokeragefee(Long brokeragefee) {
		this.brokerageFee = brokeragefee;
	}
	public Long getRentArea() {
		return rentArea;
	}
	public void setRentArea(Long rentArea) {
		this.rentArea = rentArea;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerphonenumber() {
		return managerPhoneNumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerPhoneNumber = managerphonenumber;
	}
	
}
