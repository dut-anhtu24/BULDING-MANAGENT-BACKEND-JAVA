package com.javaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {
	@Autowired
	private IBuildingRepository buildingRepo;
	
	@Override
	public List<BuildingDTO> FindAllBuildings() {
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		List<BuildingEntity> buildingEntities = buildingRepo.FindAllBuildings();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setAddress(item.getStreet() + ", " + item.getWard());
			building.setNumberOfBasement(item.getNumberOfBasement());
			result.add(building);
		}
		
		return result;
	}

	@Override
	public List<BuildingDTO> FindBuildingsByName(String name, Long districtId, List<String> typeCode) {
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		List<BuildingEntity> buildingEntities = buildingRepo.FindBuildingsByName(name, districtId, typeCode);
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setAddress(item.getStreet() + ", " + item.getWard());
			building.setNumberOfBasement(item.getNumberOfBasement());
			result.add(building);
		}
		
		return result;
	}
	
}
