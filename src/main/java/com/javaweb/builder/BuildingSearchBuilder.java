package com.javaweb.builder;

import java.math.BigDecimal;
import java.util.List;

// Use Builder Pattern
public class BuildingSearchBuilder {
	private String name;
	private Double floor_area;
	private Long districtId;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Integer areaFrom;
	private Integer areaTo;
	private BigDecimal rentPriceFrom;
	private BigDecimal rentPriceTo;
	private String manager_Name;
	private String manager_Phone_Number;
	private Long staffId;
	private List<String> buildingTypes;

	private BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.floor_area = builder.floor_area;
		this.districtId = builder.districtId;
		this.ward = builder.ward;
		this.street = builder.street;
		this.numberOfBasement = builder.numberOfBasement;
		this.direction = builder.direction;
		this.level = builder.level;
		this.areaFrom = builder.areaFrom;
		this.areaTo = builder.areaTo;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.manager_Name = builder.managerName;
		this.manager_Phone_Number = builder.managerPhone;
		this.staffId = builder.staffId;
		this.buildingTypes = builder.buildingTypes;
	}
	
	
	public String getName() {
		return name;
	}
	
	public Double getFloor_area() {
		return floor_area;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public String getLevel() {
		return level;
	}
	public Integer getAreaFrom() {
		return areaFrom;
	}
	public Integer getAreaTo() {
		return areaTo;
	}
	public BigDecimal getRentPriceFrom() {
		return rentPriceFrom;
	}
	public BigDecimal getRentPriceTo() {
		return rentPriceTo;
	}
	public String getManagerName() {
		return manager_Name;
	}
	public String getManagerPhone() {
		return manager_Phone_Number;
	}
	public Long getStaffId() {
		return staffId;
	}
	
	public List<String> getBuildingTypes() {
		return buildingTypes;
	}

	public static class Builder {
		private String name;
		private Double floor_area;
		private Long districtId;
		private String ward;
		private String street;
		private Integer numberOfBasement;
		private String direction;
		private String level;
		private Integer areaFrom;
		private Integer areaTo;
		private BigDecimal rentPriceFrom;
		private BigDecimal rentPriceTo;
		private String managerName;
		private String managerPhone;
		private Long staffId;
		private List<String> buildingTypes;

		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setFloor_area(Double floor_area) {
			this.floor_area = floor_area;
			return this;
		}
		public Builder setDistrictId(Long districtId) {
			this.districtId = districtId;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		public Builder setDirection(String direction) {
			this.direction = direction;
			return this;
		}
		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}
		
		public Builder setAreaFrom(Integer areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}
		
		public Builder setAreaTo(Integer areaTo) {
			this.areaTo = areaTo;
			return this;
		}
		public Builder setRentPriceFrom(BigDecimal rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}
		
		public Builder setRentPriceTo(BigDecimal rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}
		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}
		public Builder setManagerPhone(String managerPhone) {
			this.managerPhone = managerPhone;
			return this;
		}
		public Builder setStaffId(Long staffId) {
			this.staffId = staffId;
			return this;
		}
		
		public Builder setBuildingTypes(List<String> buildingTypes) {
			this.buildingTypes = buildingTypes;
			return this;
		}
	}
}
