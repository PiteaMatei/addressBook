package com.addressBook.testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setup connection variables
		String user = "superadmin";
		String pass = "superadmin";

		String jdbcUrl = "jdbc:mysql://localhost:3306/address_book?allowPublicKeyRetrieval=true&useSSL=false;";
		String driver = "com.mysql.cj.jdbc.Driver";

		// get connection to database
		try {
			PrintWriter out = response.getWriter();

			out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);

			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

			out.println("CONNECTED!!!");

			conn.close();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}
