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

        try {
            FileWriter writer = new FileWriter(fileName);

            for (Book book : books) {
                writer.write(
                        book.getTitle() + ","
                        + book.getAuthor() + ","
                        + book.getPages() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error writing books.");
        }
    }

    public void loadBooks(ArrayList<Book> books) {

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                String[] parts = line.split(",");

                Book book = new Book(
                        parts[0].trim(),
                        parts[1].trim(),
                        Integer.parseInt(parts[2].trim())
                );

                books.add(book);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("No saved books found.");
        }
    }
}