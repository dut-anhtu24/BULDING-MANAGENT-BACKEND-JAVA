package com.javaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingSearchDTO;
import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.model.BuildingSearchResponse;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {

	@Autowired 
	private IBuildingRepository repo;
	
	@Override
	public List<BuildingSearchResponse> getBuildingsByRequest(BuildingSearchRequest request) {
		List<BuildingSearchResponse> responses = new ArrayList<>();
		List<BuildingSearchDTO> buildings = repo.getBuildingsByRequest(request);
		
		for(BuildingSearchDTO building : buildings) {
			BuildingSearchResponse response = new BuildingSearchResponse();
			response.setName(building.getName());
			response.setAddress(building.getStreet() +  " " + 
								building.getWard() +  " " + 
								building.getDistrictName());
			
			response.setManagerName(building.getManagerName());
			response.setManagerPhone(building.getManagerPhoneNumber());
			response.setFloor_area(building.getFloorArea());
			response.setNumberOfBasement(building.getNumberOfBasement());
			response.setEmpty_area(0.0); // TODO: D.T trong = dien tich san - dien tich thue
			response.setRentPrice(building.getRent());
			response.setServiceFees(building.getServicePrice());
			if(building.getBrokerageFees() != null && building.getRent() != null) {
				response.setBrokerageFees(building.getBrokerageFees().multiply(building.getRent()));
			} else response.setBrokerageFees(null);	
			responses.add(response);
		}
		
		return responses;
	}
	
}
