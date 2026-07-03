package com.javaweb.repository.entity;

public class RentAreaEntity {
	private Long id;
	private Integer areaValue;
	private Long buildingId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getAreaValue() {
		return areaValue;
	}
	public void setAreaValue(Integer areaValue) {
		this.areaValue = areaValue;
	}
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
}
