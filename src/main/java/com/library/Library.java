
package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {

    private final ArrayList<Book> books = new ArrayList<>();
    private final BookRepository bookRepository = new BookRepository();

    public void addBook(Book book) {
        for (Book existingBook : books) {
            if (existingBook.getTitle().trim()
                    .equalsIgnoreCase(book.getTitle().trim())) {
                System.out.println("A book with this title already exists.");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Book title cannot be empty.");
            return;
        }

        boolean found = false;
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();

            if (book.getTitle().trim()
                    .equalsIgnoreCase(title.trim())) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book removed successfully!");
            saveBooks();
        }
    }

    public void saveBooks() {
        bookRepository.saveBooks(books);
    }

    public void loadBooks() {
        bookRepository.loadBooks(books);
    }

    public void searchBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Search title cannot be empty.");
            return;
        }

        boolean found = false;
        String searchTitle = title.trim();

        for (Book book : books) {
            if (book.getTitle().toLowerCase()
                    .contains(searchTitle.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void updateBook(
            String title, String newTitle, String author, int pages) {

        if (title == null || title.trim().isEmpty()) {
            System.out.println("Book title cannot be empty.");
            return;
        }

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().trim()
                    .equalsIgnoreCase(title.trim())) {
                book.setTitle(newTitle);
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

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
