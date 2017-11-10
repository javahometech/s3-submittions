package com.amazonaws.lambda.s3submittions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RDSUtil {
	private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static String USER_NAME = "";
	private static String PASSWORD = "";
	private static String RDS_ENDPOINT = "";
	static {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getRDSConnection() {
		Connection con = null;
		try {
			return DriverManager.getConnection(RDS_ENDPOINT, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
