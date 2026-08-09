package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingSearchResponse;
import com.javaweb.service.IBuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private IBuildingService buildingService;
	
	@GetMapping(value="/api/buildings")
	public List<BuildingSearchResponse> getBuildingsByRequest(@RequestParam Map<String, Object> request) {
		return buildingService.getBuildingsByRequest(request);
	}
}
