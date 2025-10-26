package com.jdbclearn.libmanage;

public class Books {
	
	private int id;
	private String title;
	private String author;
	private String isbn;
	private int year;
	private double price;
	
	
	public Books(int id, String title, String author, String isbn, int year, double price) {
		super();
		this.id=id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}
	
	
	public Books( String title, String author, String isbn, int year, double price) {
		super();
		
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}

	
//	id of books
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	
//	title of books
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
//	author of books
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
//	Unique ISBN code
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
//	Year of Published
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
//	Price of books
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return String.format("| %-4d| %-16s| %-14s| %-10s| %d | %-11f|", this.id,this.title,this.author,this.isbn,this.year,this.price);
	}
	
}
