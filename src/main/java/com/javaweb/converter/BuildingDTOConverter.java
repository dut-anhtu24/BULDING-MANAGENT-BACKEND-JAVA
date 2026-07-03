package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingSearchResponse;
import com.javaweb.repository.IDistrictRepository;
import com.javaweb.repository.IRentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {

	@Autowired
	private IDistrictRepository districtRepository;
	
	@Autowired
	private IRentAreaRepository rentAreaRepository;
	
	public BuildingSearchResponse toBuildingSearchResponse(BuildingEntity building) {
		BuildingSearchResponse response = new BuildingSearchResponse();
		response.setName(building.getName());
		response.setAddress(building.getStreet() +  " " + 
							building.getWard() +  " " + 
							districtRepository.findNameById(building.getId()));
		response.setManagerName(building.getManagerName());
		response.setManagerPhone(building.getManagerPhoneNumber());
		response.setFloor_area(building.getFloorArea());
		response.setNumberOfBasement(building.getNumberOfBasement());
		response.setRentPrice(building.getRent());
		response.setServiceFees(building.getServicePrice());
		if(building.getBrokerageFees() != null && building.getRent() != null) {
			response.setBrokerageFees(building.getBrokerageFees().multiply(building.getRent()));
		} else response.setBrokerageFees(null);
		
		List<RentAreaEntity> rentAreas = rentAreaRepository.getValueByBuildingId(building.getId());
		String rentAreaResult = rentAreas.stream().map(item -> item.getAreaValue().toString()).collect(Collectors.joining(","));
		response.setRentArea(rentAreaResult);
		
		return response;
	}
}
