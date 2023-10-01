package com.hpsystem.sellerservlets;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpsystem.mysqlcon.MysqlCon;

@WebServlet("/updatesellerprofile")
public class UpdateProfile extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String email = req.getParameter("email");
		String mobile =req.getParameter("mobile");
		String address = req.getParameter("address");
		HttpSession ses = req.getSession();
		int sellerid = (int) ses.getAttribute("sellerid");
		try {
			Connection con = MysqlCon.getConnector();
			String query = "update seller_details set email=?,mobile=?,address=? where seller_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,mobile);
			ps.setString(3,address);
			ps.setInt(4, sellerid);
			int result = ps.executeUpdate();
			if(result==1) {
				
			}else {
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
