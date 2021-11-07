package com.stone.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

class BasicDataSource {

	DataSource ds = null;

	BasicDataSource() {
		try {
			InitialContext initialContext = new InitialContext();
			ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/mycp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ConnectionUtil {

	private static DataSource ds = new BasicDataSource().ds;

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}