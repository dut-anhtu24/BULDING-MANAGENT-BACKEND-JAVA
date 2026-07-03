package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBCUtil {
	static final String URL = "jdbc:mysql://localhost:3306/building_management?userSSL=false";
	static final String USER = "root";
	static final String PASS = "071026";
	
	public static Connection getConnection() {
		Connection cnn = null;
		try {
			cnn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnn;
	}
}
