package com.javaweb.model;

import java.math.BigDecimal;

public class BuildingSearchResponse {
	private String name;
	private String address;
	private Integer numberOfBasement;
	private String managerName;
	private String managerPhone;
	private Double floorArea;
	private Double empty_area;
	private BigDecimal rentPrice;
	private BigDecimal servicePrice;
	private BigDecimal brokerageFees;
	private String rentArea;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public Double getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Double floorArea) {
		this.floorArea = floorArea;
	}
	public Double getEmpty_area() {
		return empty_area;
	}
	public void setEmpty_area(Double empty_area) {
		this.empty_area = empty_area;
	}
	public BigDecimal getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(BigDecimal rentPrice) {
		this.rentPrice = rentPrice;
	}
	public BigDecimal getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(BigDecimal servicePrice) {
		this.servicePrice = servicePrice;
	}
	public BigDecimal getBrokerageFees() {
		return brokerageFees;
	}
	public void setBrokerageFees(BigDecimal brokerageFees) {
		this.brokerageFees = brokerageFees;
	}
	public String getRentArea() {
		return rentArea;
	}
	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}
	
}
