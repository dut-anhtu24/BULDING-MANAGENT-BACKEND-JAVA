package com.javaweb.model;

import java.math.BigDecimal;
import java.util.List;

public class BuildingSearchResponse {
	private String name;
	private String address;
	private Integer numberOfBasement;
	private String managerName;
	private String managerPhone;
	private Double floor_area;
	private Double empty_area;
	private BigDecimal rentPrice;
	private BigDecimal serviceFees;
	private BigDecimal brokerageFees;
	
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
	public Double getFloor_area() {
		return floor_area;
	}
	public void setFloor_area(Double floor_area) {
		this.floor_area = floor_area;
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
	public BigDecimal getServiceFees() {
		return serviceFees;
	}
	public void setServiceFees(BigDecimal serviceFees) {
		this.serviceFees = serviceFees;
	}
	public BigDecimal getBrokerageFees() {
		return brokerageFees;
	}
	public void setBrokerageFees(BigDecimal brokerageFees) {
		this.brokerageFees = brokerageFees;
	}
	public List<String> getRentArea() {
		return rentArea;
	}
	public void setRentArea(List<String> rentArea) {
		this.rentArea = rentArea;
	}
	private List<String> rentArea;
}
