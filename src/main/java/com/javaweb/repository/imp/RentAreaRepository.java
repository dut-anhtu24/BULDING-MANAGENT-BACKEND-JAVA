package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.IRentAreaRepository;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.utils.ConnectionJDBCUtil;

@Repository
public class RentAreaRepository implements IRentAreaRepository{

	@Override
	public List<RentAreaEntity> getValueByBuildingId(Long id) {
		String sql = "SELECT * FROM rentarea WHERE rentarea.buildingid = " + id;
		List<RentAreaEntity> rentAreas = new ArrayList<>();
		try(Connection cnn = ConnectionJDBCUtil.getConnection();
			Statement stmt = cnn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			while(rs.next()) {
				RentAreaEntity rentArea = new RentAreaEntity();
				rentArea.setId(rs.getLong("id"));
				rentArea.setAreaValue(rs.getInt("areavalue"));
				rentArea.setBuildingId(rs.getLong("buildingid"));
				
				rentAreas.add(rentArea);
			}
		} catch(SQLException e) {
			System.out.println("Connection to DB failed in RentArea Field");
		}
		return rentAreas;
	}

}
