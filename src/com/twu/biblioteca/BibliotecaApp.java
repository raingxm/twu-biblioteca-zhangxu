package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private static List<String> books = new ArrayList<String>();

    public static void addSomeBooksToLib() {
        books.add("C++ Primer");
        books.add("Java HeadFirst");
    }

    public static void showBookList() {
        for(String book : books) {
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
