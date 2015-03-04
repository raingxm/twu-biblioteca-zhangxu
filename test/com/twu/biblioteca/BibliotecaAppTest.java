package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;

    @Before
    public void generateInitBooksInLib() {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testSeeWelcomeMessageAndMainMenuWhenAppStartup() {
        StringBuilder startMessage = new StringBuilder();
        showWelcomeMessage(startMessage);
        showMainMenu(startMessage);

        ByteArrayOutputStream output = setSystemOutput();

        bibliotecaApp.libraryHomePage();
        assertEquals(startMessage.toString(), output.toString());
    }

    @Test
    public void testWhenUserSelectOnePrintBookList() {
        StringBuilder expect = new StringBuilder();
        showBookList(expect);
        ByteArrayOutputStream output = setSystemOutput();

        bibliotecaApp.selectMenuOption(1);
        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testWhenUserSelectInvalidOptionShowWarningMessage() {
        bibliotecaApp.addSomeBooksToLib();
        StringBuilder expect = new StringBuilder();
        showInvalidOptionWarningMessage(expect);

        ByteArrayOutputStream output = setSystemOutput();

        bibliotecaApp.selectMenuOption(22);
        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testContinueChooseOptionUntilPressQuit() {
        StringBuilder expect = new StringBuilder();
        showWelcomeMessage(expect);
        showMainMenu(expect);
        showBookList(expect);
        showInvalidOptionWarningMessage(expect);
        showBookList(expect);
        setSystemInput("1\n22\n1\nquit");

        ByteArrayOutputStream output = setSystemOutput();
        BibliotecaApp.main(new String[]{});

        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testCheckoutBookAndTheBookNotAppearsInLibBookList() {
        bibliotecaApp.addANewBookToLibrary("Ruby on Rails", "Dave Thomas", 2007);
        Book checkBook = getBookInLastOfBookList();
        bibliotecaApp.checkoutBook(checkBook.getName());
        bibliotecaApp.showBookList();

        ByteArrayOutputStream bookList = setSystemOutput();
        assertTrue(bookList.toString().indexOf(checkBook.toString()) == -1);
    }

    @Test
    public void testCheckoutBookSuccessShowSuccessMessage() {
        StringBuilder expect = new StringBuilder();
        showCheckoutBookPromptMessage(expect);
        expect.append("Thank you! Enjoy the book\n");

        ByteArrayInputStream inputBookName = setSystemInput("C++ Primer");
        ByteArrayOutputStream output = setSystemOutput();
        bibliotecaApp.selectMenuOption(MainMenu.CHECKOUT_BOOK_OPTION);
        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testSeeReturnBookOptionInMainMenu() {
        StringBuilder checkoutMessage = new StringBuilder();
        checkoutMessage.append("3: Return Book\n");

        ByteArrayOutputStream output = setSystemOutput();
        bibliotecaApp.showMainMenu();

        assertTrue(output.toString().indexOf(checkoutMessage.toString()) != -1);
    }

    @Test
    public void testCheckoutBookFailShowPromptMessage() {
        StringBuilder expect = new StringBuilder();
        showCheckoutBookPromptMessage(expect);
        expect.append("That book is not available.\n");

        ByteArrayInputStream inputBookName = setSystemInput("C Primer");
        ByteArrayOutputStream output = setSystemOutput();
        bibliotecaApp.selectMenuOption(MainMenu.CHECKOUT_BOOK_OPTION);
        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testReturnBook() {
        Book book = getBookInLastOfBookList();
        bibliotecaApp.checkoutBook(book.getName());
        assertTrue(book.isBorrowOut());
        bibliotecaApp.returnBook(book.getName());
        assertFalse(book.isBorrowOut());
    }

    @Test
    public void testReturnBookSuccessShowPromptMessage() {
        Book book = getBookInLastOfBookList();
        bibliotecaApp.checkoutBook(book.getName());
        ByteArrayOutputStream output = setSystemOutput();
        bibliotecaApp.returnBook(book.getName());
        assertEquals(output.toString(), "Thank you for returning the book.\n");
    }

    @Test
    public void testReturnBookFailShowPromptMessage() {
        Book bookNotInBookList = new Book("HeadFirst Python", "Dahl", 2008);
        ByteArrayOutputStream output = setSystemOutput();
        bibliotecaApp.returnBook(bookNotInBookList.getName());
        assertEquals(output.toString(), "That is not a valid book to return.\n");
    }

    private Book getBookInLastOfBookList() {
        List<Book> books = bibliotecaApp.getBookList();
        return books.get(books.size()-1);
    }

    private void showCheckoutBookPromptMessage(StringBuilder stringBuilder) {
        stringBuilder.append("please checkout book(type book name)\n");
    }

    private ByteArrayOutputStream setSystemOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

    private ByteArrayInputStream setSystemInput(String inputVal) {
        ByteArrayInputStream in = new ByteArrayInputStream(inputVal.getBytes());
        System.setIn(in);
        return in;
    }

    private void showMainMenu(StringBuilder stringBuilder) {
        stringBuilder.append("Main Menu(select one options below, such as 1 or 2):\n");
        stringBuilder.append("1: Display Book List\n");
        stringBuilder.append("2: Checkout Book\n");
        stringBuilder.append("3: Return Book\n");
    }

    private void showWelcomeMessage(StringBuilder stringBuilder) {
        stringBuilder.append("welcome to use biblioteca\n");
    }

    private void showBookList(StringBuilder stringBuilder) {
        stringBuilder.append("Book List:\n");
        stringBuilder.append("C++ Primer | Bob | 1998\n");
        stringBuilder.append("Java HeadFirst | Luce | 2007\n");
    }

    private void showInvalidOptionWarningMessage(StringBuilder stringBuilder) {
        stringBuilder.append("Select an invalid option, retry please:\n");
    }
}