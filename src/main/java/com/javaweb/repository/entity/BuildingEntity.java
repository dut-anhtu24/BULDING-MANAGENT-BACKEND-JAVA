package com.javaweb.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="name", nullable=false)
	private String name;

	@Column(name="ward")
	private String ward;

	@Column(name="street")
	private String street;

	@Column(name="structure")
	private String structure;

	@Column(name="numberOfBasement")
	private Integer numberOfBasement;

	@Column(name="floorArea")
	private Double floorArea;
	
	@Column(name="direction")
	private String direction;

	@Column(name="buildingLevel")
	private String buildingLevel;

	@Column(name="rentPrice")
	private BigDecimal rentPrice;

	@Column(name="servicePrice")
	private BigDecimal servicePrice;

	@Column(name="carFees")
	private BigDecimal carFees;

	@Column(name="motoFees")
	private BigDecimal motoFees;

	@Column(name="overhoursFees")
	private BigDecimal overhoursFees;

	@Column(name="electricityPay")
	private BigDecimal electricityPay;

	@Column(name="deposit")
	private BigDecimal deposit;

	@Column(name="payment")
	private String payment;

	@Column(name="rentalTerm")
	private String rentalTerm;
	
	@Column(name="decorationTime")
	private String decorationTime;

	@Column(name="managerName")
	private String managerName;

	@Column(name="managerPhoneNumber")
	private String managerPhoneNumber;
	
	@Column(name="brokerageFees")
	private BigDecimal brokerageFees;

	@Column(name="notes")
	private String notes;
	
	@ManyToOne
	@JoinColumn(name="districtId")
	private DistrictEntity district;
	
	@OneToMany(mappedBy = "building", fetch=FetchType.LAZY)
	private List<RentAreaEntity> rentAreas = new ArrayList<>();

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

	public List<RentAreaEntity> getRentAreas() {
		return rentAreas;
	}

	public void setRentAreas(List<RentAreaEntity> rentAreas) {
		this.rentAreas = rentAreas;
	}

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
