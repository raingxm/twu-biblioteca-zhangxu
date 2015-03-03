package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class BibliotecaApp {
    private List<Book> books = new ArrayList<Book>();

    public BibliotecaApp() {
        addSomeBooksToLib();
    }

    public List<Book> getBookList() {
        return books;
    }

    public static void main(String[] args) {
        new BibliotecaApp().run();
    }

    public void addSomeBooksToLib() {
        addANewBookToLibrary("C++ Primer", "Bob", 1998);
        addANewBookToLibrary("Java HeadFirst", "Luce", 2007);
    }

    public void showWelcomeMessage() {
        System.out.println("welcome to use biblioteca");
    }

    public void showMainMenu() {
        System.out.println("Main Menu(select one options below, such as 1 or 2):");
        System.out.println("1: Display Book List");
        System.out.println("2: Checkout Book");
    }

    public void showBookList() {
        System.out.println("Book List:");
        for(Book book : books) {
            System.out.println(book);
        }
    }

    public void startLibraryPage() {
        showWelcomeMessage();
        showMainMenu();
    }

    public void run() {
        startLibraryPage();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        while(!option.equals("quit")) {
            selectMenu(option);
            option = scanner.next();
        }
    }

    public void selectMenu(String option) {
        if(parseInt(option) == 1) {
            showBookList();
        } else {
            System.out.println("Select an invalid option, retry please:");
        }
    }

    public void addANewBookToLibrary(String name, String author, int publishYear) {
        this.books.add(new Book(name, author, publishYear));
    }

    public void checkoutBook(Book checkBook) {
        books.remove(checkBook);
    }
}
