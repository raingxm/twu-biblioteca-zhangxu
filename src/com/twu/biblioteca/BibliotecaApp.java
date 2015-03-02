package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private static List<Book> books = new ArrayList<Book>();

    public static void addSomeBooksToLib() {
        books.add(new Book("C++ Primer", "Bob", 1998));
        books.add(new Book("Java HeadFirst", "Luce", 2007));
    }

    public static void showBookList() {
        for(Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        addSomeBooksToLib();
        System.out.println("welcome to use biblioteca");
        System.out.println("Book List:");
        showBookList();
    }
}
