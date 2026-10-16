
package com.library.repository;

import com.library.model.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRepository {

    private final String fileName = "books";

    public void saveBooks(ArrayList<Book> books) {
        try (FileWriter writer = new FileWriter(fileName)) {

            for (Book book : books) {
                writer.write(
                        book.getTitle() + ","
                        + book.getAuthor() + ","
                        + book.getPages() + "\n"
                );
            }

        } catch (IOException e) {
            System.out.println("Error writing books.");
        }
    }

    public void loadBooks(ArrayList<Book> books) {
        try (Scanner reader = new Scanner(new File(fileName))) {

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",", -1);

                try {
                    if (parts.length != 3) {
                        throw new IllegalArgumentException(
                                "Invalid book format."
                        );
                    }

                    Book book = new Book(
                            parts[0].trim(),
                            parts[1].trim(),
                            Integer.parseInt(parts[2].trim())
                    );

                    boolean duplicate = false;

                    for (Book existingBook : books) {
                        if (existingBook.getTitle().trim()
                                .equalsIgnoreCase(book.getTitle().trim())) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println(
                                "Skipping duplicate book: " + book.getTitle()
                        );
                    } else {
                        books.add(book);
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println(
                            "Skipping invalid book record: " + line
                    );
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No saved books found.");
        }
    }
}
