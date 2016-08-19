package com.adobe.dao.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String DRIVER = ConfigReader.getString("DB_DRIVER"); //$NON-NLS-1$
	private static String URL = ConfigReader.getString("DB_URL"); //$NON-NLS-1$
	private static String USER = ConfigReader.getString("DB_USER"); //$NON-NLS-1$
	private static String PWD = ConfigReader.getString("DB_PWD"); //$NON-NLS-1$
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PWD);
	}
	
	public static void releaseStatement(Statement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	public static void releaseConnection(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}
