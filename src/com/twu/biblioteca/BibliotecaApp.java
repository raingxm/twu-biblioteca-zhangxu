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
        switch (option) {
            case MainMenu.SHOW_BOOK_LIST_OPTION:
                showBookList();
                break;
            case MainMenu.CHECKOUT_BOOK_OPTION:
                enterCheckoutMenu();
                break;
            case MainMenu.RETURN_BOOK_OPTION:
                enterReturnBookMenu();
                break;
            default:
                MainMenu.invalidOptionPromptMessage();
        }
    }

    public void showBookList() {
        System.out.println("Book List:");
        for(Book book : books) {
            if(!book.isBorrowOut())
                System.out.println(book);
        }
    }

    public void enterCheckoutMenu() {
        showCheckBookPromptMessage();
        Scanner checkoutScanner = new Scanner(System.in);
        String bookName = checkoutScanner.nextLine();
        checkoutBook(bookName);
    }

    public void checkoutBook(String bookName) {
        Book checkout = findBookInBookListByName(bookName);
        if(checkout != null){
            checkout.borrowOut();
            showBorrowBookSuccessMessage();
        } else {
            showBorrowBookFailMessage();
        }
    }

    public void enterReturnBookMenu() {
        showReturnBookPromptMessage();
        Scanner returnScanner = new Scanner(System.in);
        String bookName = returnScanner.nextLine();
        returnBook(bookName);
    }

    public void returnBook(String bookName) {
        Book checkout = findBookInBookListByName(bookName);
        if(checkout != null){
            checkout.returnBack();
            showReturnBookSuccessMessage();
        } else {
            showReturnBookFailMessage();
        }
    }

    public void addSomeBooksToLib() {
        addANewBookToLibrary("C++ Primer", "Bob", 1998);
        addANewBookToLibrary("Java HeadFirst", "Luce", 2007);
    }

    public void showWelcomeMessage() {
        System.out.println("welcome to use biblioteca");
    }

    public void showMainMenu() {
        MainMenu.show();
    }

    public void libraryHomePage() {
        showWelcomeMessage();
        MainMenu.show();
    }

    public void addANewBookToLibrary(String name, String author, int publishYear) {
        this.books.add(new Book(name, author, publishYear));
    }

    private Book findBookInBookListByName(String bookName) {
        for(Book book: books) {
            if(book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }

    private void showReturnBookSuccessMessage() {
        System.out.println("Thank you for returning the book.");
    }

    private void showReturnBookFailMessage() {
        System.out.println("That is not a valid book to return.");
    }

    private void showBorrowBookFailMessage() {
        System.out.println("That book is not available.");
    }

    private void showBorrowBookSuccessMessage() {
        System.out.println("Thank you! Enjoy the book");
    }

    private void showReturnBookPromptMessage() {
        System.out.println("please return book(type book name)");
    }

    private void showCheckBookPromptMessage() {
        System.out.println("please checkout book(type book name)");
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
}
