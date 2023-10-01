package com.hpsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Add extends javax.servlet.http.HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
	    String email=req.getParameter("email");
	    String password =req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		out.print("<html><body><p style='color:red;'>"+email+" "+password+"</p></body></html>");
	}
}
