package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.BuildingEntity;

public interface IBuildingRepository {
	List<BuildingEntity> FindAllBuildings();
	List<BuildingEntity> FindBuildingsByName(String name, Long distridId, List<String> typeCode);
}
