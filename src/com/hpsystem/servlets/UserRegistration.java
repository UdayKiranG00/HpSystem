package com.hpsystem.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpsystem.bean.User;
import com.hpsystem.bean.UserAddress;
import com.hpsystem.mysqlcon.MysqlCon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/userregister")
public class UserRegistration extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		User u = new User() ;
		u.firstname = req.getParameter("firstname");
		u.lastname = req.getParameter("lastname");
		u.email = req.getParameter("email");
		u.mobile = req.getParameter("mobile");
		u.gender = req.getParameter("gender");
		u.password = req.getParameter("password");
		UserAddress ua = new UserAddress();
		ua.houseNumber=req.getParameter("housenumber");
		ua.streetName=req.getParameter("streetname");
		ua.locality=req.getParameter("locality");
		ua.mandal=req.getParameter("mandal");
		ua.district=req.getParameter("district");
		ua.state=req.getParameter("state");
		ua.pinCode=Integer.parseInt(req.getParameter("pincode"));
		try {
			Connection con = MysqlCon.getConnector();
			String query="insert into user_details (firstname,lastname,gender,email,mobile,password) values(?,?,?,?,?,?)";
			PreparedStatement st1 = con.prepareStatement(query);
			st1.setString(1,u.firstname);
			st1.setString(2, u.lastname);
			st1.setString(3, u.gender);
			st1.setString(4, u.email);
			st1.setString(5, u.mobile);
			st1.setString(6, u.password);
			int details = st1.executeUpdate();
			query="insert into user_address (housenumber,streetname,locality,mandal,district,state,pincode,user_id) values(?,?,?,?,?,?,?,?)";
			ResultSet rs ;
			if(details==1) {
				String squery="select * from user_details where password=?";
				PreparedStatement sst=con.prepareStatement(squery);
				sst.setString(1, u.password);
				rs = sst.executeQuery();
				if(rs.next()) {
					ua.user_id=rs.getInt(1);
					PreparedStatement st2 = con.prepareStatement(query);
					st2.setString(1, ua.houseNumber);
					st2.setString(2, ua.streetName);
					st2.setString(3, ua.locality);
					st2.setString(4, ua.mandal);
					st2.setString(5, ua.district);
					st2.setString(6, ua.state);
					st2.setInt(7, ua.pinCode);
					st2.setInt(8, ua.user_id);
					int address = st2.executeUpdate();
					PrintWriter out= res.getWriter();
					if(address==1) {
						out.print("Registered Successfully");
					}else {
						out.print("Error");
					}
				}
			}
			st1.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
