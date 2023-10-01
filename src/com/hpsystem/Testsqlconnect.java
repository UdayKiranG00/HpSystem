package com.hpsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Testsqlconnect {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fms","root","root");
		String query="insert into user_details (firstname,lastname,gender,email,mobile,password) values(?,?,?,?,?,?)";
		PreparedStatement st1 = con.prepareStatement(query);
		st1.setString(1, "cc");
		st1.setString(2, "cc");
		st1.setString(3, "cc");
		st1.setString(4, "cc");
		st1.setString(5, "cc");
		st1.setString(6, "cc");
		int count = st1.executeUpdate();
		System.out.println(count);
	}

}
