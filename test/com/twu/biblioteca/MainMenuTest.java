package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainMenuTest {

    @Test
    public void testSeeCheckoutOptionInMainMenu() {
        StringBuilder checkoutMessage = new StringBuilder();
        checkoutMessage.append("2: Checkout Book\n");

        ByteArrayOutputStream output = setSystemOutput();
        MainMenu.show();

        assertTrue(output.toString().contains(checkoutMessage.toString()));
        assertTrue(output.toString().indexOf(checkoutMessage.toString()) >= 0);
    }

    public void testSeeListMovieOptionInMainMenu() {
        StringBuilder checkoutMessage = new StringBuilder();
        checkoutMessage.append("4: Show Movie Lfist\n");

        ByteArrayOutputStream output = setSystemOutput();
        MainMenu.show();

        assertEquals(-1, output.toString().indexOf(checkoutMessage.toString()));
    }

    private ByteArrayOutputStream setSystemOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

}