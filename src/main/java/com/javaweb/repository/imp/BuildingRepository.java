package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.IBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepository implements IBuildingRepository {
	static final String URL = "jdbc:mysql://localhost:3306/building_management?userSSL=false";
	static final String USER = "root";
	static final String PASS = "071026";
	
	@Override
	public List<BuildingEntity> FindAllBuildings() {
		String sql = "SELECT * FROM building";
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection cnn = DriverManager.getConnection(URL, USER, PASS);
				Statement stmt = cnn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("NUMBEROFBASEMENT"));
				result.add(building);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.print("Connected to databse failed...");
		}
		
		return result;
	}

	@Override
	public List<BuildingEntity> FindBuildingsByName(String name, Long districtId, List<String> typeCodes) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b");
		if(typeCodes != null && !name.isEmpty()) {
			sql.append(" join building_buildingtype bbt on b.id = bbt.BUILDINGID\r\n"
					+ "join buildingtype bt on bbt.BUILDINGTYPEID = bt.id\r\n");
			
		}
		
		sql.append("where 1 = 1 ");
		if(name != null || !name.isEmpty()) {
			sql.append(" AND b.name like '%" + name + "%' ");
		}
		if(districtId != null) {
			sql.append(" AND b.districtid = " + districtId + " ");
		}
		
		if(typeCodes != null && !name.isEmpty()) {
			sql.append("AND (");
			for(int i = 0; i < typeCodes.size(); i++) {
				if(i > 0) 
					sql.append(" OR ");
				sql.append(" bt.code = '" + typeCodes.get(i) + "' ");
			}
			
			sql.append(")");
		}
		
		
		System.err.print(sql);
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection cnn = DriverManager.getConnection(URL, USER, PASS);
				Statement stmt = cnn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString())){
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("NUMBEROFBASEMENT"));
				result.add(building);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.print("Connected to databse failed...");
		}
		
		return result;
	}	
}
