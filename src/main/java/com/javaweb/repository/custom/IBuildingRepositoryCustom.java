package com.javaweb.repository.custom;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.entity.BuildingEntity;

public interface IBuildingRepositoryCustom {
	List<BuildingEntity> getBuildingsByRequest(BuildingSearchBuilder request);	
}
