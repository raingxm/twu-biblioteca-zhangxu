package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    private static List<Book> books = new ArrayList<Book>();

    public static void addSomeBooksToLib() {
        books.add(new Book("C++ Primer", "Bob", 1998));
        books.add(new Book("Java HeadFirst", "Luce", 2007));
    }

    public static void showWelcomeMessage() {
        System.out.println("welcome to use biblioteca");
    }

    public static void showMainMenu() {
        System.out.println("Main Menu(select one options below, such as 1 or 2):");
        System.out.println("1: Display Book List");
    }

    public static void showBookList() {
        System.out.println("Book List:");
        for(Book book : books) {
            System.out.println(book);
        }
    }

    public static void startGame() {
        addSomeBooksToLib();
        showWelcomeMessage();
        showMainMenu();
    }

    public static void main(String[] args) {
       startGame();
    }
}
