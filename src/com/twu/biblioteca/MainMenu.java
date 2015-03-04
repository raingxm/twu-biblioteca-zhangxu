package com.twu.biblioteca;

/**
 * Created by xuzhang on 3/4/15.
 */
public class MainMenu {
    public static final int SHOW_BOOK_LIST_OPTION = 1;
    public static final int CHECKOUT_BOOK_OPTION = 2;

    public static void show() {
        System.out.println("Main Menu(select one options below, such as 1 or 2):");
        System.out.println(SHOW_BOOK_LIST_OPTION + ": Display Book List");
        System.out.println(CHECKOUT_BOOK_OPTION + ": Checkout Book");
    }
}
