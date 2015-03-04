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
    }

    private ByteArrayOutputStream setSystemOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

}