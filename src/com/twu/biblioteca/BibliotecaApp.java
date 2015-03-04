package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class BibliotecaApp {
    public static final int SHOW_BOOK_LIST_OPTION = 1;
    public static final int CHECKOUT_BOOK_OPTION = 2;
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

    public void run() {
        libraryHomePage();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        while(!option.equals("quit")) {
            if(isValidIntOption(option)) {
                selectMenuOption(parseInt(option));
                option = scanner.nextLine();
            } else {
                MainMenu.invalidOptionPromptMessage();
            }
        }
    }

    public void selectMenuOption(int option) {
        if(option == SHOW_BOOK_LIST_OPTION) {
            showBookList();
        } else if(option == CHECKOUT_BOOK_OPTION) {
            enterCheckoutMenu();
        } else {
            MainMenu.invalidOptionPromptMessage();
        }
    }

    private boolean isValidIntOption(String option) {
        try {
            parseInt(option);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void enterCheckoutMenu() {
        showCheckBookPromptMessage();
        Scanner checkoutScanner = new Scanner(System.in);
        String bookName = checkoutScanner.nextLine();
        checkoutBook(bookName);
    }

    public void addSomeBooksToLib() {
        addANewBookToLibrary("C++ Primer", "Bob", 1998);
        addANewBookToLibrary("Java HeadFirst", "Luce", 2007);
    }

    private void showCheckBookPromptMessage() {
        System.out.println("please checkout book(type book name)");
    }

    public void showWelcomeMessage() {
        System.out.println("welcome to use biblioteca");
    }

    public void showMainMenu() {
        MainMenu.show();
    }

    public void showBookList() {
        System.out.println("Book List:");
        for(Book book : books) {
            System.out.println(book);
        }
    }

    public void libraryHomePage() {
        showWelcomeMessage();
        MainMenu.show();
    }

    public void addANewBookToLibrary(String name, String author, int publishYear) {
        this.books.add(new Book(name, author, publishYear));
    }

    public void checkoutBook(String bookName) {
        if(findBookInBookListByName(bookName) != null){
            books.remove(findBookInBookListByName(bookName));
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }
    }

    private Book findBookInBookListByName(String bookName) {
        for(Book book: books) {
            if(book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }
}
