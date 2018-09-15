package com.ljn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DButil {
	   public static String url="jdbc:oracle:thin:@127.0.0.1:1521/LJ";
	   public static String user="ljn";
	   public static String password="123456";
	   public static String sql="select *from users";
	   private static  Connection conn=null;
	static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
                conn= DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	 
	public static Connection getConnection() {
		return conn;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			String name=rs.getString("unique");
			
			System.out.println(name);
		}
	}	
}
