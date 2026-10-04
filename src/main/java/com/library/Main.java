package com.library;
import java.io.*;
import java.util.*;

import com.library.model.Book;

public class Main {
    public static void main(String[] args) {
    Library library = new Library();
    library.loadBooks();
    Scanner input = new Scanner(System.in);
    int choice;
    String title;
String author;
int pages;
    do{
    System.out.println("  ======Library Management System======");
    System.out.println("1. Add Book ");
    System.out.println("2. Display Book ");
    System.out.println("3. Remove Book ");
    System.out.println("4. Search Book ");
    System.out.println("5. Update Book ");
    System.out.println("6. Exit ");
    System.out.println("Enter Choice: ");

try {
    choice = input.nextInt();
    input.nextLine();
} catch (InputMismatchException e) {
    System.out.println("Invalid input. Please enter a number.");
    input.nextLine();
    choice = 0;
    continue;
};
        switch(choice) {
           case 1:
    try {
        System.out.println("Enter Title: ");
        title = input.nextLine();

        System.out.println("Enter Author: ");
         author = input.nextLine();

        System.out.println("Enter Pages: ");
       pages = input.nextInt();
        input.nextLine();

        Book book = new Book(title, author, pages);
        library.addBook(book);
        library.saveBooks();

        System.out.println("Book added successfully!");

    } catch (InputMismatchException e) {
        System.out.println("Please enter a valid number for pages.");
        input.nextLine();

    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    break;
                
            case 2:
                library.displayBooks();
                break;
            case 3 :
                System.out.println("Enter Book title to remove: ");
                title = input.nextLine();
                library.removeBook(title);
                library.saveBooks();
                break;
            case 4:
                  System.out.println("enter Book title to Search: ");
                  title = input.nextLine();
                  library.searchBook(title);
                  break;
            case 5:
                System.out.println("Enter Book title to update: ");
                title = input.nextLine();
                System.out.println("Enter New Book title  to update: ");
                String newTitle = input.nextLine();
                System.out.println("Enter Book author to update: ");
                author = input.nextLine();
                System.out.println("Enter Book pages to update: ");
                pages = input.nextInt();
                input.nextLine();
                library.updateBook(title, newTitle,author, pages);
                break;
            case 6:
                System.out.println("Thank you for using our library!");
                break;
                default:
                    System.out.println("Invalid choice. Try again");
        }
        }while(choice != 6);
    input.close();
    }
    }
