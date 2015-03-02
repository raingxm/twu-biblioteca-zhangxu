package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void testSeeWelcomeMessageAndBookListWhenAppStartup() {
        StringBuilder startMessage = new StringBuilder();
        startMessage.append(showWelcomeMessage());
        startMessage.append(showBookList());

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        BibliotecaApp.main(new String[]{});

        assertEquals(startMessage.toString(), output.toString());
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
}