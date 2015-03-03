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

        bibliotecaApp.startLibraryPage();
        assertEquals(startMessage.toString(), output.toString());
    }

    @Test
    public void testWhenUserSelectOnePrintBookList() {
        StringBuilder expect = new StringBuilder();
        showBookList(expect);
        ByteArrayOutputStream output = setSystemOutput();

        bibliotecaApp.selectMenu("1");
        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testWhenUserSelectInvalidOptionShowWarningMessage() {
        bibliotecaApp.addSomeBooksToLib();
        StringBuilder expect = new StringBuilder();
        showInvalidOptionWarningMessage(expect);

        ByteArrayOutputStream output = setSystemOutput();

        bibliotecaApp.selectMenu("22");
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
        List<Book> books = bibliotecaApp.getBookList();
        int numOfBooks = books.size();
        Book checkBook = books.get(numOfBooks-1);
        bibliotecaApp.checkoutBook(checkBook.getName());
        assertEquals(numOfBooks - 1, books.size());
        assertFalse(books.contains(checkBook));
    }

    @Test
    public void testSeeCheckoutOptionInMainMenu() {
        StringBuilder expect = new StringBuilder();
        expect.append("Main Menu(select one options below, such as 1 or 2):\n");
        expect.append("1: Display Book List\n");
        expect.append("2: Checkout Book\n");

        ByteArrayOutputStream output = setSystemOutput();
        bibliotecaApp.showMainMenu();

        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testSelectTwoThenShowPromptMessage() {
        StringBuilder expect = new StringBuilder();
        expect.append("please checkout book(type book name)\n");

        ByteArrayOutputStream output = setSystemOutput();
        bibliotecaApp.selectMenu(BibliotecaApp.CHECKOUT_BOOK_OPTION + "");
        assertEquals(expect.toString(), output.toString());
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