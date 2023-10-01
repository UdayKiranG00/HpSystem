package com.hpsystem.servlets;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpsystem.mysqlcon.MysqlCon;

@WebServlet("/login")
public class Login extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res){
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			PrintWriter out = res.getWriter();
			Connection con = MysqlCon.getConnector();
			String query1 = "select * from user_details where email=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setString(1, email);
			ResultSet rs1 = ps1.executeQuery();
			HttpSession ses = req.getSession();
			if(rs1.next()) {
				if(password.equals(rs1.getString(7))) {
					ses.setAttribute("userid", rs1.getInt(1));
					out.print("logged in as user successfully.");
				}else {
					out.print("entered email or password are wrong..");
				}
			}else {
				ps1.close();
				String query2 = "select * from seller_details where email=?";
				PreparedStatement ps2=con.prepareStatement(query2);
				ps2.setString(1, email);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					if(password.equals(rs2.getString(7))) {
						ses.setAttribute("sellerid", rs2.getInt(1));
						ses.setAttribute("selleremail", rs2.getString(4));
						ses.setAttribute("sellermobile", rs2.getString(5));
						ses.setAttribute("selleraddress", rs2.getString(8));
						ses.setAttribute("sellerpassword", rs2.getString(7));
						res.sendRedirect("SellerModule/welcomeseller.jsp");
					}else {
						out.print("entered email or password are wrong..");
					}
				}else {
					out.print("No user found with the given mail");
				}
				ps2.close();
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
