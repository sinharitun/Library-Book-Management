📚 Library Book Management System

This is a simple, console-based Java application designed to manage a library's book inventory. It serves as a mini-project to practice Core Java principles (OOP, classes, encapsulation) combined with JDBC (Java Database Connectivity) for persistent data storage.

✨ Features (CRUD Operations)

The application provides a menu-driven interface to perform the following actions:

Add Book (Create): Insert new book details (Title, Author, ISBN, Year, Price) into the database.

View All Books (Read All): Retrieve and display a list of all books in the inventory.

Search by ISBN (Read Single): Find and display a specific book using its unique ISBN code.

Update Book Price (Update): (To be implemented) Modify the price of an existing book.

Delete Book (Delete): (To be implemented) Remove a book record from the inventory.

🛠️ Technology Stack

Language: Java (Core Java)

Database: MySQL (or any other relational database supported by JDBC)

Database Access: JDBC (Java Database Connectivity)

Architecture: Simplified Layered Architecture (Model-DAO-Controller)

📁 Project Structure

File

Role

Description

Book.java

Model

Encapsulates book data (id, title, author, isbn, price). Includes the toString() method for formatted printing.

BookDAO.java

DAO (Data Access Object)

The only class that interacts with the database. Handles connection, PreparedStatement binding, and mapping ResultSet data back to Book objects.

LibraryApp.java

Controller / Main

Contains the main method. Handles the console menu, user input (Scanner), and directs requests to the BookDAO.

🚀 Setup and Running the Project

Prerequisites

Java Development Kit (JDK): Version 8 or later.

Relational Database: MySQL is assumed.

JDBC Driver: Download the appropriate driver JAR file (e.g., mysql-connector-java.jar) and add it to your project's classpath.

Database Configuration

Create Database: Create a database named libmanagement.

CREATE DATABASE libmanagement;
USE libmanagement;


Create Table: Run the following SQL to create the books table:

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    year INT,
    price DECIMAL(10, 2)
);


Update Credentials: Open BookDAO.java and update the following variables with your local database credentials:

private String url="jdbc:mysql://localhost:3306/libmanagement";
private String user="root";
private String pass="YOUR_PASSWORD"; // <-- CHANGE THIS


Execution

Compile and run the LibraryApp.java file. The application will launch with a console menu.
