package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class BibliotecaApp {
    private static List<Book> books = new ArrayList<Book>();

    public BibliotecaApp() {
        addSomeBooksToLib();
    }

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

    public static void startLibraryPage() {
        showWelcomeMessage();
        showMainMenu();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        startLibraryPage();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        while(!option.equals("quit")) {
            selectMenu(option);
            option = scanner.next();
        }
    }

    public static void selectMenu(String option) {
        if(parseInt(option) == 1) {
            showBookList();
        } else {
            System.out.println("Select an invalid option, retry please:");
        }
    }
}
