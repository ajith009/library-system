package com.library;
import com.library.model.Book;
import java.io.*;
import java.util.*;
import com.library.repository.BookRepository;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    private BookRepository bookRepository = new BookRepository();
    void addBook(Book book){
        books.add(book);
    }

    void removeBook(String title) {
        boolean found = false;   // ① Start by assuming the book is NOT found
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                found = true;    // ② We found and removed the book
                break;
            }
        }
        if (!found) {            // ③ After the loop finishes
            System.out.println("Book not found.");
        } else {
            System.out.println("Book removed successfully!");
        }
    }
    void saveBooks() {
    bookRepository.saveBooks(books);
}

void loadBooks() {
    bookRepository.loadBooks(books);
}

    void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book found successfully!");
                book.displayBook();
                found = true;
                break;
            }
           }
        if (!found) {
            System.out.println("Book not found.");
        }
    }


    void updateBook(String title,String newTitle, String author, int pages) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setTitle( newTitle);
                book.setAuthor(author);
                book.setPages(pages);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        } else {
            saveBooks();
            System.out.println("Book updated successfully!");

        }
    }

    void displayBooks(){
        if(books.isEmpty()){
            System.out.println("No books found");
        }
        else{
            for(Book book : books){
                book.displayBook();
            }
        }
    }
}
