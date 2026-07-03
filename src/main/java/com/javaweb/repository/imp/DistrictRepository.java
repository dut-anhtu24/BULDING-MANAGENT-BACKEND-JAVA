package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.IDistrictRepository;
import com.javaweb.utils.ConnectionJDBCUtil;

@Repository
public class DistrictRepository implements IDistrictRepository {

	@Override
	public String findNameById(Long id) {
		String sql = "SELECT name FROM district WHERE district.id = " + id;
		String name = "";
		try(Connection cnn = ConnectionJDBCUtil.getConnection();
			Statement stmt = cnn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Connect to databse failed in Districts Fiel");
		}
		
		return name;
	}

}
