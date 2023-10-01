package com.hpsystem.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpsystem.bean.Seller;
import com.hpsystem.bean.ShopDetails;
import com.hpsystem.mysqlcon.MysqlCon;

@WebServlet("/sellerregistration")
public class SellerRegistration extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		Seller s = new Seller() ;
		s.firstname = req.getParameter("firstname");
		s.lastname = req.getParameter("lastname");
		s.email = req.getParameter("email");
		s.mobile = req.getParameter("mobile");
		s.gender = req.getParameter("gender");
		s.password = req.getParameter("password");
		s.address = req.getParameter("address");
		ShopDetails sd = new ShopDetails();
		sd.shopName=req.getParameter("shopname");
		sd.streetName=req.getParameter("streetname");
		sd.locality=req.getParameter("locality");
		sd.mandal=req.getParameter("mandal");
		sd.district=req.getParameter("district");
		sd.state=req.getParameter("state");
		sd.pincode=Integer.parseInt(req.getParameter("pincode"));
		try {
			Connection con = MysqlCon.getConnector();
			String query="insert into seller_details (firstname,lastname,gender,email,mobile,password,address) values(?,?,?,?,?,?,?)";
			PreparedStatement st1 = con.prepareStatement(query);
			st1.setString(1, s.firstname);
			st1.setString(2, s.lastname);
			st1.setString(3, s.gender);
			st1.setString(4, s.email);
			st1.setString(5, s.mobile);
			st1.setString(6, s.password);
			st1.setString(7, s.address);
			int details = st1.executeUpdate();
			query="insert into shop_details (shopname,streetname,locality,mandal,district,state,pincode,seller_id) values(?,?,?,?,?,?,?,?)";
			ResultSet rs ;
			if(details==1) {
				String squery="select * from seller_details where password=?";
				PreparedStatement sst=con.prepareStatement(squery);
				sst.setString(1, s.password);
				rs = sst.executeQuery();
				if(rs.next()) {
					sd.seller_id=rs.getInt(1);
					PreparedStatement st2 = con.prepareStatement(query);
					st2.setString(1, sd.shopName);
					st2.setString(2, sd.streetName);
					st2.setString(3, sd.locality);
					st2.setString(4, sd.mandal);
					st2.setString(5, sd.district);
					st2.setString(6, sd.state);
					st2.setInt(7, sd.pincode);
					st2.setInt(8, sd.seller_id);
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
