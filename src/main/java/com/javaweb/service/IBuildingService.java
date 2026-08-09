package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.model.BuildingSearchResponse;

public interface IBuildingService {
	List<BuildingSearchResponse> getBuildingsByRequest(BuildingSearchRequest request);
	List<BuildingSearchResponse> getBuildingsByRequest(Map<String, Object> request);
}
