package com.javaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.model.BuildingSearchResponse;
import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.StringUtil;

@Service
public class BuildingService implements IBuildingService {

	@Autowired 
	private IBuildingRepository buildingRepository;
	
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	
	@Override
	public List<BuildingSearchResponse> getBuildingsByRequest(BuildingSearchRequest request) {
		// Handle logic for building types
		request.setBuildingTypes(StringUtil.stringNormalList(request.getBuildingTypes()));
		
		List<BuildingEntity> buildingEntities = buildingRepository.getBuildingsByRequest(request);
		List<BuildingSearchResponse> result = new ArrayList<>();
		for(BuildingEntity building : buildingEntities) {
			BuildingSearchResponse response = buildingDTOConverter.toBuildingSearchResponse(building);
			result.add(response);
		}
		
		return result;
	}
	
}
