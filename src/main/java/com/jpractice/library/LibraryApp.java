package com.jpractice.library;

public class LibraryApp {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook("Clean Code");
        lib.addBook("The Pragmatic Programmer");
        lib.borrowBook("Clean Code");
        lib.borrowBook("The Mythical Man-Month"); // Not present
        lib.returnBook("Clean Code");
        lib.listAvailableBooks();
    }
}
