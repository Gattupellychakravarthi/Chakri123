package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ExecuteQueryTest {
	
	public void ReadQuery() throws SQLException {
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "root");
		Statement state =con.createStatement();
		
	}
	

}
