package com.jdbclearn.libmanage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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

	//	Getting all books Data Stored in the database
	public List<Books> getAllBooks() {

		String query="Select * from books";
		List<Books> allBooks = new ArrayList<Books>();

		try(Connection con = DriverManager.getConnection(url,user,pass);
				Statement ps = con.createStatement()) {


			ResultSet result=ps.executeQuery(query);


			while(result.next()) {
				Books book=new Books(result.getInt("id"),result.getString("title"),result.getString("author"),result.getString("isbn"),result.getInt("year"),result.getDouble("price"));
				allBooks.add(book);

			}


		} catch (SQLException e) {
			System.err.println("Somthing went wrong in data fetching");
		}
		return allBooks;

	}

	// Getting specific data of book using its ISBN unique code
	public Books getBookByISBN(String input) {

		String query="Select * from books WHERE isbn = ?";

		Books book=null;

		try(Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, input);

			ResultSet result=ps.executeQuery();
			if(result.next()) {
				book=new Books(result.getInt("id"),result.getString("title"),result.getString("author"),result.getString("isbn"),result.getInt("year"),result.getDouble("price"));
			}	

		} catch (SQLException e) {
			System.err.println("Somthing went wrong in data fetching");
		}

		return book;

	}
	
	public boolean updatePrice(String isbn,double price) {
		
		String query="UPDATE BOOKS SET price=? where isbn=?";
		int rowAffected=0;
		
		try (Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps=con.prepareStatement(query)){
			ps.setDouble(1, price);
			ps.setString(2, isbn);
			
			rowAffected=ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("problem occured  while updating the price of book.");
		}
		if(rowAffected>0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean deleteRecord(String isbn) {
		
		String query="DELETE FROM books where isbn=?";
		int rowAffected=0;
		
		try (Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps=con.prepareStatement(query)){
			ps.setString(1, isbn);
			rowAffected=ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Problem occured during deleting the record ");
		}
		
		if(rowAffected>0) {
			return true;
		}
		else {
			return false;
		}
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
