package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    @Before
    public void createApp() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testSeeWelcomeMessageAndMainMenuWhenAppStartup() {
        StringBuilder startMessage = new StringBuilder();
        startMessage.append(showWelcomeMessage());
        startMessage.append(showMainMenu());

        ByteArrayOutputStream output = setSystemOutput();

        BibliotecaApp.startLibraryPage();
        assertEquals(startMessage.toString(), output.toString());
    }

    @Test
    public void testWhenUserSelectOnePrintBookList() {
        StringBuilder expect = new StringBuilder();
        expect.append(showBookList());

        ByteArrayOutputStream output = setSystemOutput();

        BibliotecaApp.selectMenu("1");
        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testWhenUserSelectInvalidOptionShowWarningMessage() {
        StringBuilder expect = new StringBuilder();
        expect.append(showInvalidOptionWarningMessage());

        ByteArrayOutputStream output = setSystemOutput();

        BibliotecaApp.selectMenu("22");
        assertEquals(expect.toString(), output.toString());
    }

    @Test
    public void testContinueChooseOptionUntilPressQuit() {
        StringBuilder expect = new StringBuilder();
        expect.append(showWelcomeMessage());
        expect.append(showMainMenu());
        expect.append(showBookList());
        expect.append(showInvalidOptionWarningMessage());
        expect.append(showBookList());
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

    private String showMainMenu() {
        StringBuilder mainMenu = new StringBuilder();
        mainMenu.append("Main Menu(select one options below, such as 1 or 2):\n");
        mainMenu.append("1: Display Book List\n");
        return mainMenu.toString();
    }

    private String showWelcomeMessage() {
        return "welcome to use biblioteca\n";
    }

    private String showBookList() {
        StringBuilder bookList = new StringBuilder();
        bookList.append("Book List:\n");
        bookList.append("C++ Primer | Bob | 1998\n");
        bookList.append("Java HeadFirst | Luce | 2007\n");
        return bookList.toString();
    }

    private String showInvalidOptionWarningMessage() {
        return "Select an invalid option, retry please:\n";
    }
}