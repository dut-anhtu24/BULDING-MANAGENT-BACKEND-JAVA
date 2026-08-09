package com.javaweb.repository;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.entity.BuildingEntity;

public interface IBuildingRepository {
	List<BuildingEntity> getBuildingsByRequest(BuildingSearchRequest request);
	List<BuildingEntity> getBuildingsByRequest(BuildingSearchBuilder request);	
}
