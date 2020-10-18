package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcConnection {

	public static void main (String args[]) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to database "+ jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connecting successful");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
