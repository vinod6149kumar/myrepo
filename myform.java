package com.jsp.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/myform")
public class myform extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
		String username=req.getParameter("user_name");
		String password=req.getParameter("password");
		String mail=req.getParameter("user_mail");
		String gender=req.getParameter("user_gender");
		String course=req.getParameter("user_course");
		
            resp.setContentType("Text/html");
			PrintWriter pw=resp.getWriter();
			pw.println("<h2>welcome to form</h2>");

			String url="jdbc:mysql://localhost:3306?user=root&password=12345";
			String query="insert into test.userinfo values(?,?,?,?,?)";
			

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement ps=connection.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, mail);
				ps.setString(4, gender);
				ps.setString(5, course);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					pw.println("updated successfully");
				}
				else {
					pw.println("re-enter");
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
		
	}
	

}
