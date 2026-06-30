package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingSearchDTO;
import com.javaweb.model.BuildingSearchRequest;
import com.javaweb.repository.IBuildingRepository;

@Repository
public class BuildingRepository implements IBuildingRepository {
	static final String URL = "jdbc:mysql://localhost:3306/building_management?userSSL=false";
	static final String USER = "root";
	static final String PASS = "071026";
		
	@Override
	public List<BuildingSearchDTO> getBuildingsByRequest(BuildingSearchRequest request) {
		StringBuilder sql = new StringBuilder("select b.name, b.floor_area, d.name as districtname, "
				+ "b.ward, b.street, b.numberofbasement, b.rent, b.service_price, "
				+ "b.manager_name, b.manager_phone_number, b.brokerage_fees\n"
				+ "" // TODO: Viet them Query de lay ra List dien tich thue
				+ "from building b ");
		sql.append("left join district d on b.districtid = d.id\n");
		// TODO: Join them bang renttype de tinh list dien tich thue
		if(request.getBuildingTypes() != null && !request.getBuildingTypes().isEmpty()) {
			sql.append("join building_buildingtype bbt on b.id = bbt.BUILDINGID\n"
					+ "join buildingtype bt on bbt.BUILDINGTYPEID = bt.id\n");
		}
		
		if(request.getStaffId() != null) {
			sql.append("left join assignmentbuilding ab on ab.buildingid = b.id\n"
					+ "join user u on u.id = ab.staffid\n");
		}
		
		if(request.getAreaFrom() != null || request.getAreaTo() != null) {
			sql.append("join rentarea ra on ra.buildingid = b.id\n");
		}
		
		sql.append("where 1 = 1 ");
		validateSearDataRequest(sql, request);
		sql.append("\ngroup by b.id\n");
		
		System.out.println(sql);
		
		List<BuildingSearchDTO> result = new ArrayList<>();
		try(Connection cnn = DriverManager.getConnection(URL, USER, PASS);
			Statement stmt = cnn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString())) {
			while(rs.next()) {
				BuildingSearchDTO building = new BuildingSearchDTO();
				building.setName(rs.getString("name"));
				building.setWard(rs.getString("ward"));
				building.setDistrictName(rs.getString("districtname"));
				building.setStreet(rs.getString("street"));
				building.setFloorArea(rs.getDouble("floor_area"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				building.setRent(rs.getBigDecimal("rent"));
				building.setServicePrice(rs.getBigDecimal("service_price"));
				building.setManagerName(rs.getString("manager_name"));
				building.setManagerPhoneNumber(rs.getString("manager_phone_number"));
				building.setBrokerageFees(rs.getBigDecimal("brokerage_fees"));
				
				result.add(building);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Connect to databse failed...");
		}
		return result;
	}
	
	public void validateSearDataRequest(StringBuilder sql, BuildingSearchRequest request) {
		if(request.getName() != null && !request.getName().isEmpty()) {
			sql.append("AND b.name like '%" + request.getName() + "%' ");
		}
		
		if(request.getDistrictId() != null) {
			sql.append("AND b.districtid = " + request.getDistrictId() + " ");
		}
		
		if(request.getFloor_area() != null) {
			sql.append("AND b.floor_area = " + request.getFloor_area() + " ");
		}
		
		if(request.getLevel() != null) {
			sql.append("AND b.building_level = '" + request.getLevel() + "' ");
		}
		
		if(request.getDirection() != null && !request.getDirection().isEmpty()) {
			sql.append("AND b.direction like '%" + request.getDirection() + "%' ");
		}
		
		if(request.getAreaFrom() != null || request.getAreaTo() != null) {
			if(request.getAreaFrom() != null && request.getAreaTo() != null) {
				sql.append("AND ra.areavalue between " + request.getAreaFrom()
						+ " and " + request.getAreaTo() + " ");
			}
			else if(request.getAreaFrom() != null) {
				sql.append("AND ra.areavalue >= " + request.getAreaFrom() + " ");
			}
			else sql.append("AND ra.areavalue <= " + request.getAreaTo() + " ");
		}
		
		if(request.getRentPriceFrom() != null || request.getRentPriceTo() != null) {
			if(request.getRentPriceFrom() != null && request.getRentPriceTo() != null) {
				sql.append("AND b.rent >= " + request.getRentPriceFrom() 
						+ " AND b.rent <= " + request.getRentPriceTo() + " ");
			}
			else if(request.getRentPriceFrom() != null) {
				sql.append("AND b.rent >= " + request.getRentPriceFrom() + " ");
			}
			else sql.append("AND b.rent <= " + request.getRentPriceTo() + " ");
		}
		
		if(request.getManagerName() != null && !request.getManagerName().isEmpty()) {
			sql.append("AND b.manager_name like '%" + request.getManagerName() + "%' ");
		}
		
		if(request.getManagerPhone() != null && !request.getManagerPhone().isEmpty()) {
			sql.append("AND b.manager_phone_number like  '%" + request.getManagerPhone() + "%' ");
		}
		
		if(request.getWard() != null && !request.getWard().isEmpty()) {
			sql.append("AND b.ward like '%" + request.getWard() + "%' ");
		}
		
		if(request.getStreet() != null && !request.getStreet().isEmpty()) {
			sql.append("AND b.street like '%" + request.getStreet() + "%' ");
		}
		
		if(request.getNumberOfBasement() != null) {
			sql.append("AND b.numberofbasement = " + request.getNumberOfBasement());
		}
		
		if(request.getBuildingTypes() != null && !request.getBuildingTypes().isEmpty()) {
			sql.append("AND ( ");
			List<String> types = request.getBuildingTypes();
			for(int i = 0; i < types.size(); i++) {
				if(i > 0)
					sql.append(" OR ");
				sql.append("bt.code = '" + types.get(i) + "' ");
			}
			
			sql.append(");");
		}
	}
}