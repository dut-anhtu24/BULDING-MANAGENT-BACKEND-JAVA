package com.javaweb.service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
		// Handle logic for building types
		List<String> types = request.getBuildingTypes(); 
		if(types != null && !types.isEmpty()
			&& types.stream().noneMatch(Objects::isNull)) {
			if(types.size() == 1) {
				types = Arrays.asList(types.get(0).split("-"));
			}
			
			request.setBuildingTypes(types);
		}
		
		List<BuildingSearchDTO> buildings = repo.getBuildingsByRequest(request);
		Map<Long, BuildingSearchResponse> map = new LinkedHashMap<>();
		
		for(BuildingSearchDTO building : buildings) {
			BuildingSearchResponse response = map.get(building.getId());
			if(response == null) {
				response = new BuildingSearchResponse();
				setSearchResponse(response, building);
				
				map.put(building.getId(), response);
			} 
			
			String rentarea = building.getRentArea();
			if(rentarea != null) {
				if(response.getRentArea() == null) {
					response.setRentArea(rentarea);
				} else response.setRentArea(response.getRentArea() + ", " + rentarea);
			}			
		}
		
 		// Set dien tich trong
		for(Map.Entry<Long, BuildingSearchResponse> mp : map.entrySet()) {
			String rentarea = mp.getValue().getRentArea();
			if(rentarea != null && !rentarea.isEmpty()) {
				String[] values = rentarea.split(",");
				int sumOfRentArea = 0;
				for(String value : values) {
					sumOfRentArea += Integer.parseInt(value.trim());
				}
				
				Double floorArea = mp.getValue().getFloor_area();
				mp.getValue().setEmpty_area(floorArea - sumOfRentArea);
			}
		}
		
		return new ArrayList<>(map.values());
	}
	
	public void setSearchResponse(BuildingSearchResponse response, BuildingSearchDTO building) {
		response.setName(building.getName());
		response.setAddress(building.getStreet() +  " " + 
							building.getWard() +  " " + 
							building.getDistrictName());
		
		response.setManagerName(building.getManagerName());
		response.setManagerPhone(building.getManagerPhoneNumber());
		response.setFloor_area(building.getFloorArea());
		response.setNumberOfBasement(building.getNumberOfBasement());
		response.setRentPrice(building.getRent());
		response.setServiceFees(building.getServicePrice());
		if(building.getBrokerageFees() != null && building.getRent() != null) {
			response.setBrokerageFees(building.getBrokerageFees().multiply(building.getRent()));
		} else response.setBrokerageFees(null);	
	}
}
