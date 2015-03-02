package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void testSeeWelcomeMessageAndBookListWhenAppStartup() {
        StringBuilder startMessage = new StringBuilder();
        startMessage.append("welcome to use biblioteca\n");
        startMessage.append("Book List:\n");
        startMessage.append("C++ Primer\n");
        startMessage.append("Java HeadFirst\n");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        BibliotecaApp.main(new String[]{});

        assertEquals(startMessage.toString(), output.toString());
    }

}