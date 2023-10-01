package com.hpsystem.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hpsystem.mysqlcon.MysqlCon;
import com.oreilly.servlet.MultipartRequest;
@WebServlet("/accesskeyregister")
public class AccesskeyRegister extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> file1 = null;
		String license_name = null ;
		String email = null;
		try {
			file1 = sf.parseRequest(req);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(FileItem item : file1 ) {
			if(item.isFormField()) {
				email = item.getString();
				continue;
			}
			if(item.getName()!=null) {
				try {
					item.write(new File("C:/eclipse_workspace/hpsystem/"+item.getName()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				license_name = item.getName();
			}
		}

		try {
			PrintWriter out = res.getWriter();
			Connection con = MysqlCon.getConnector();
			String query = "insert into seller_license (email,license_name) values (?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,license_name);
			int ack = ps.executeUpdate();
			if(ack == 1) {
				out.print("Registered Successfully");
			}else {
				out.print("Try again");
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
