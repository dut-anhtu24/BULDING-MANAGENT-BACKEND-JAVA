package com.javaweb.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customerException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.service.IBuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private IBuildingService buildingService;
	
	@GetMapping(value="/api/building/")
	public List<BuildingDTO> getAllBuildings() {
		List<BuildingDTO> result = buildingService.FindAllBuildings();
		return result;
	}
	
	@GetMapping(value="/api/building/", params = "name")
	public List<BuildingDTO> getBuildingsByName(@RequestParam(name="name", required = false) String name,
												@RequestParam(name="districtId", required = false) Long districtId,
												@RequestParam(name="typeCode", required = false) List<String> typeCodes) {
		if(typeCodes != null) {
			if(typeCodes.size() == 1) {
				typeCodes= Arrays.asList(typeCodes.get(0).split("-"));
			}
		}
		List<BuildingDTO> result = buildingService.FindBuildingsByName(name, districtId, typeCodes);
		return result;
	}
	
	public void validate(BuildingDTO building) {
		if(building == null || building.getName() == null || building.getName().equals("") || building.getNumberOfBasement() == null) {
			throw new FieldRequiredException("Name or Number of Basement is null!");
		}
	}
}
