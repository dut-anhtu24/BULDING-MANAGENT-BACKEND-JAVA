package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.model.BuildingSearchResponse;

public interface IBuildingService {
	List<BuildingSearchResponse> getBuildingsByRequest(BuildingSearchRequest request);
}
