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
        startLibraryPage();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        while(!option.equals("quit")) {
            selectMenu(option);
            option = scanner.next();
        }
    }

    public void selectMenu(String option) {
        if(parseInt(option) == SHOW_BOOK_LIST_OPTION) {
            showBookList();
        } else if(parseInt(option) == CHECKOUT_BOOK_OPTION) {
            showCheckBookPromptMessage();
        } else {
            System.out.println("Select an invalid option, retry please:");
        }
    }

    public void addSomeBooksToLib() {
        addANewBookToLibrary("C++ Primer", "Bob", 1998);
        addANewBookToLibrary("Java HeadFirst", "Luce", 2007);
    }

    public void showCheckBookPromptMessage() {
        System.out.println("please checkout book(type book name)");
    }

    public void showWelcomeMessage() {
        System.out.println("welcome to use biblioteca");
    }

    public void showMainMenu() {
        System.out.println("Main Menu(select one options below, such as 1 or 2):");
        System.out.println(SHOW_BOOK_LIST_OPTION + ": Display Book List");
        System.out.println(CHECKOUT_BOOK_OPTION + ": Checkout Book");
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

    public void addANewBookToLibrary(String name, String author, int publishYear) {
        this.books.add(new Book(name, author, publishYear));
    }

    public void checkoutBook(String bookName) {
        if(findBookInBookListByName(bookName) != null){
            books.remove(findBookInBookListByName(bookName));
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
