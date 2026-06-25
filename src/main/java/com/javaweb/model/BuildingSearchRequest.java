package com.javaweb.model;

import java.math.BigDecimal;
import java.util.List;

public class BuildingSearchRequest {
	private String name;
	private Double floor_area;
	private Long districtId;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Double areaFrom;
	private Double areaTo;
	private BigDecimal rentPriceFrom;
	private BigDecimal rentPriceTo;
	private String managerName;	private String managerPhone;
	private Long staffId;
	private List<String> buildingTypes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFloor_area() {
		return floor_area;
	}
	public void setFloor_area(Double floor_area) {
		this.floor_area = floor_area;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districId) {
		this.districtId = districId;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Double getAreaFrom() {
		return areaFrom;
	}
	public void setAreaFrom(Double areaFrom) {
		this.areaFrom = areaFrom;
	}
	public Double getAreaTo() {
		return areaTo;
	}
	public void setAreaTo(Double areaTo) {
		this.areaTo = areaTo;
	}
	public BigDecimal getRentPriceFrom() {
		return rentPriceFrom;
	}
	public void setRentPriceFrom(BigDecimal rentPriceFrom) {
		this.rentPriceFrom = rentPriceFrom;
	}
	public BigDecimal getRentPriceTo() {
		return rentPriceTo;
	}
	public void setRentPriceTo(BigDecimal rentPriceTo) {
		this.rentPriceTo = rentPriceTo;
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
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public List<String> getBuildingTypes() {
		return buildingTypes;
	}
	public void setBuildingTypes(List<String> buildingTypes) {
		this.buildingTypes = buildingTypes;
	}
	
	
}
