package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="buildingtype")
public class BuildingTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="code")
	private String code;

	@Column(name="name")
	private String name;
	
	@ManyToMany(mappedBy = "buildingTypes", fetch = FetchType.LAZY)
	private List<BuildingEntity> buildings = new ArrayList<>();
}
