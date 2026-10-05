package com.library;
import com.library.model.Book;
import java.io.*;
import java.util.*;
import com.library.repository.BookRepository;

public class Library {

    private final ArrayList<Book> books = new ArrayList<>();
    private final BookRepository bookRepository = new BookRepository();
    void addBook(Book book){
        books.add(book);
    }

   public void removeBook(String title) {
    boolean found = false;

    Iterator<Book> iterator = books.iterator();

    while (iterator.hasNext()) {
        Book book = iterator.next();

        if (book.getTitle().equalsIgnoreCase(title)) {
            iterator.remove();
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Book not found.");
    } else {
        System.out.println("Book removed successfully!");
    }
}
  public void saveBooks() {
    bookRepository.saveBooks(books);
}

public void loadBooks() {
    bookRepository.loadBooks(books);
}

   public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
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


   public void updateBook(String title,String newTitle, String author, int pages) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
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

  public  void displayBooks(){
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
