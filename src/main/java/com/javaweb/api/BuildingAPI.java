package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.model.BuildingSearchResponse;
import com.javaweb.service.IBuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private IBuildingService buildingService;
	
	@GetMapping(value="/api/buildings")
	public List<BuildingSearchResponse> getBuildingsByRequest(BuildingSearchRequest request) {
		return buildingService.getBuildingsByRequest(request);
	}
}
