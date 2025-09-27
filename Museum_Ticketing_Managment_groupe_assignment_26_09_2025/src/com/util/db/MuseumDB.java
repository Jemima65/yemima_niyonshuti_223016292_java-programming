//GROUP ASSIGNMENT_26_09_2025
//GROUP 15
//NIYONSABA Erina 223007511
//NIYIGENA Djamila 223017067
//NIYONSHUTI Yemima 223016292


package com.util.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MuseumDB {

	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/museumdb","root","");
	}

	
}
