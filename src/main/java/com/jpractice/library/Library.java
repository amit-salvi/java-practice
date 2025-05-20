package com.jpractice.library;

import java.util.*;

public class Library {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(String title) {
        if (!books.containsKey(title)) {
            books.put(title, new Book(title));
            System.out.println("Book added: " + title);
        } else {
            System.out.println("Book already exists.");
        }
    }

    public void borrowBook(String title) {
        Book book = books.get(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
        } else {
            book.borrow();
            System.out.println("You borrowed: " + title);
        }
    }

    public void returnBook(String title) {
        Book book = books.get(title);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isBorrowed()) {
            System.out.println("Book was not borrowed.");
        } else {
            book.returnBook();
            System.out.println("You returned: " + title);
        }
    }

    public void listAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (!book.isBorrowed()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }
}
