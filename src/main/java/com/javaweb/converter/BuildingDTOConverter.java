package com.javaweb.converter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingSearchResponse toBuildingSearchResponse(BuildingEntity building) {
		BuildingSearchResponse response = modelMapper.map(building, BuildingSearchResponse.class);
		response.setAddress(building.getStreet() +  " " + 
							building.getWard() +  " " + 
							districtRepository.findNameById(building.getId()));
		List<RentAreaEntity> rentAreas = rentAreaRepository.getValueByBuildingId(building.getId());
		String rentAreaResult = rentAreas.stream().map(item -> item.getAreaValue().toString()).collect(Collectors.joining(","));
		response.setRentArea(rentAreaResult);
		BigDecimal brokerageFees = caculationBrokerageFees(response.getRentPrice(), response.getBrokerageFees());
		response.setBrokerageFees(brokerageFees);
		
		return response;
	}
	
	private BigDecimal caculationBrokerageFees(BigDecimal rent, BigDecimal brokerageFees) {
		if(rent != null && brokerageFees != null) {
			return rent.multiply(brokerageFees);
		}
		return null;
	}
}
