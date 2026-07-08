package com.javaweb.repository.entity;

import java.math.BigDecimal;

public class BuildingEntity {
	private Long id;

	private String name;

	private Long districtId;

	private String ward;

	private String street;

	private String structure;

	private Integer numberOfBasement;

	private Double floorArea;

	private String direction;

	private String buildingLevel;

	private BigDecimal rentPrice;

	private BigDecimal servicePrice;

	private BigDecimal carFees;

	private BigDecimal motoFees;

	private BigDecimal overhoursFees;

	private BigDecimal electricityPay;

	private BigDecimal deposit;

	private String payment;

	private String rentalTerm;

	private String decorationTime;

	private String managerName;

	private String managerPhoneNumber;

	private BigDecimal brokerageFees;

	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
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

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Double getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Double floorArea) {
		this.floorArea = floorArea;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getBuildingLevel() {
		return buildingLevel;
	}

	public void setBuildingLevel(String buildingLevel) {
		this.buildingLevel = buildingLevel;
	}

	public BigDecimal getRent() {
		return rentPrice;
	}

	public void setRent(BigDecimal rent) {
		this.rentPrice = rent;
	}

	public BigDecimal getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(BigDecimal servicePrice) {
		this.servicePrice = servicePrice;
	}

	public BigDecimal getCarFees() {
		return carFees;
	}

	public void setCarFees(BigDecimal carFees) {
		this.carFees = carFees;
	}

	public BigDecimal getMotoFees() {
		return motoFees;
	}

	public void setMotoFees(BigDecimal motoFees) {
		this.motoFees = motoFees;
	}

	public BigDecimal getOverhoursFees() {
		return overhoursFees;
	}

	public void setOverhoursFees(BigDecimal overhoursFees) {
		this.overhoursFees = overhoursFees;
	}

	public BigDecimal getElectricityPay() {
		return electricityPay;
	}

	public void setElectricityPay(BigDecimal electricityPay) {
		this.electricityPay = electricityPay;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getRentalTerm() {
		return rentalTerm;
	}

	public void setRentalTerm(String rentalTerm) {
		this.rentalTerm = rentalTerm;
	}

	public String getDecorationTime() {
		return decorationTime;
	}

	public void setDecorationTime(String decorationTime) {
		this.decorationTime = decorationTime;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public BigDecimal getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(BigDecimal rentPrice) {
		this.rentPrice = rentPrice;
	}

	public BigDecimal getBrokerageFees() {
		return brokerageFees;
	}

	public void setBrokerageFees(BigDecimal brokerageFees) {
		this.brokerageFees = brokerageFees;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
