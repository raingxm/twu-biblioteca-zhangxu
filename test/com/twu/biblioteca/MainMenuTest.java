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

        assertTrue(isOutputContainExpect(output, checkoutMessage));
    }

    @Test
    public void testSeeListMovieOptionInMainMenu() {
        StringBuilder checkoutMessage = new StringBuilder();
        checkoutMessage.append("4: Show Movie List\n");

        ByteArrayOutputStream output = setSystemOutput();
        MainMenu.show();
        assertTrue(isOutputContainExpect(output, checkoutMessage));
    }

    @Test
    public void testSeeCheckoutMovieOptionInMainMenu() {
        StringBuilder checkoutMessage = new StringBuilder();
        checkoutMessage.append("5: Checkout Movie(type movie name)\n");

        ByteArrayOutputStream output = setSystemOutput();
        MainMenu.show();
        assertTrue(isOutputContainExpect(output, checkoutMessage));
    }

    private ByteArrayOutputStream setSystemOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

    private boolean isOutputContainExpect(ByteArrayOutputStream output, StringBuilder expect) {
        return output.toString().indexOf(expect.toString()) != -1;
    }
}