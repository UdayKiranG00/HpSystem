package com.hpsystem.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpsystem.mysqlcon.MysqlCon;
import java.sql.*;

@WebServlet("/registeraccess")
public class RegisterAccess extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		String email = req.getParameter("email");
		String accesskey = req.getParameter("accesskey");
		try {
			Connection con = MysqlCon.getConnector();
			String query = "select * from seller_accesskey where accesskey=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, accesskey);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(2));
				if(rs.getString(2).equals(email)) {
					res.sendRedirect("SellerRegistration.jsp");
				}
			}
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
