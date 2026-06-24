package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;

public interface IBuildingService {
	List<BuildingDTO> FindAllBuildings();
	List<BuildingDTO> FindBuildingsByName(String name, Long districtId, List<String> typeCode);
}
