package com.jdbclearn.libmanage;

import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		BookDAO bdao=new BookDAO();
		
		try {
			
			System.out.println("--------------- WELCOME TO LIBRARY BOOK MANAGEMENT SYSTEM ---------------\n\n");
			
			boolean flag=true;
			while(flag) {
				System.out.println("------------------------------ MENU ------------------------------\n");
				System.out.println("1. Add Book");
				System.out.println("2. View All Books");
				System.out.println("3. Search by ISBN");
				System.out.println("4. Update Book Price");
				System.out.println("5. Delete Book");
				System.out.println("6. Exit");
				
				System.out.println("Choose one Option from the Given Menu (ex: 1)");
				int option=scan.nextInt();
				scan.nextLine();
				
				switch(option) {
				case 1:
					System.out.println("Enter the book details here---------");
					
					System.out.println("\nEnter Title of Book: ");
					String title=scan.nextLine();
					System.out.print("\nEnter author name: ");
					String author=scan.nextLine();
					System.out.print("Enter unique ISBN code:");
					String isbn=scan.nextLine();
					System.out.print("Enter year: ");
					int year=scan.nextInt();
					System.out.print("Enter price of book: ");
					double price=scan.nextInt();
					Books book=new Books(title, author, isbn, year, price);
					boolean result=bdao.addBook(book);
					if(result) {
						System.out.println("Task Completed");
					}
					else {
						System.out.println("Try again");
					}
					break;
				case 2:
					continue;
				case 3: 
					continue;
				case 4: 
					continue;
				case 5:
					continue;
				case 6:
					flag=false;
				}
				
			}
			
			
			
			
			
		} catch (Exception e) {
			System.err.println("Something went wrong :- "+e);
		}
		finally {
			System.out.println("---------------  ThankYou For Using LIBRARY BOOK MANAGEMENT SYSTEM ---------------\n\n");
			scan.close();
			
		}

	}	

}
