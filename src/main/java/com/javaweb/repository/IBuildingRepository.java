package com.javaweb.repository;

import java.util.List;

import com.javaweb.model.BuildingSearchDTO;
import com.javaweb.model.BuildingSearchRequest;

public interface IBuildingRepository {
	List<BuildingSearchDTO> getBuildingsByRequest(BuildingSearchRequest request);
}
