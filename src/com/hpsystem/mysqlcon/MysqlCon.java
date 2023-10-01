package com.hpsystem.mysqlcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlCon {
	static public Connection getConnector() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fms","root","root");
		return con;
	}
}
