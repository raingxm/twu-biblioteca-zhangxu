package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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