package com.jdbclearn.libmanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {

	private String url="jdbc:mysql://localhost:3306/libmanagement";
	private String user="root";
	private String pass="Nitte@071";

	//  Constructor for	Loading Driver
	public BookDAO() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.err.println("Problem occured during driver Loading");
			e.printStackTrace();
		} 
	}


	//	Adding New Books Data in Database
	public boolean addBook(Books book) {

		String insertData= "INSERT INTO BOOKS(title,author,isbn,year,price) VALUES(?,?,?,?,?)";
		int rowAffected=0;

		try (Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = con.prepareStatement(insertData)){

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3,book.getIsbn());
			ps.setInt(4,book.getYear());
			ps.setDouble(5, book.getPrice());


			rowAffected = ps.executeUpdate();
			if(rowAffected>0) {
				System.out.println("Book "+book.getTitle()+" is added successfully");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}


		return rowAffected>0;
	}


}
