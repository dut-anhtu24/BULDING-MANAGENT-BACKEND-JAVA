package com.javaweb.converter;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> request) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
														.setName(MapUtil.getObject(request, "name", String.class))
														.setFloor_area(MapUtil.getObject(request, "floor_area", Double.class))
														.setDistrictId(MapUtil.getObject(request, "districtId", Long.class))
														.setWard(MapUtil.getObject(request, "ward", String.class))
														.setStreet(MapUtil.getObject(request, "street", String.class))
														.setNumberOfBasement(MapUtil.getObject(request, "numberOfBasement", Integer.class))
														.setDirection(MapUtil.getObject(request, "direction", String.class))
														.setLevel(MapUtil.getObject(request, "level", String.class))
														.setAreaFrom(MapUtil.getObject(request, "areaFrom", Integer.class))
														.setAreaTo(MapUtil.getObject(request, "areaTo", Integer.class))
														.setRentPriceFrom(MapUtil.getObject(request, "rentPriceFrom", BigDecimal.class))
														.setRentPriceTo(MapUtil.getObject(request, "rentPriceTo", BigDecimal.class))
														.setManagerName(MapUtil.getObject(request, "managerName", String.class))
														.setManagerPhone(MapUtil.getObject(request, "managerPhone", String.class))
														.setStaffId(MapUtil.getObject(request, "staffId", Long.class))
														.build();
		
		return buildingSearchBuilder;													
	}
}
