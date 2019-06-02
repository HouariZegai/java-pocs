package com.houarizegai.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=FALSE&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to Database: " + jdbcUrl);
			Class.forName(driver);
			Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Connection success !");
			
			myCon.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
