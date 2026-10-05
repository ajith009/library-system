package com.library.model;

public class Book {

    private String title;
    private String author;
    private int pages;

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
    }

    private void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
    }

    private void validatePages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be greater than 0.");
        }
    }

  public Book(String title, String author, int pages) {

    validateTitle(title);
    validateAuthor(author);
    validatePages(pages);

    this.title = title;
    this.author = author;
    this.pages = pages;
}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
    validateTitle(title);

    this.title = title;
}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
   validateAuthor(author);

    this.author = author;
}

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
 validatePages(pages);

    this.pages = pages;
}

    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
    }
}