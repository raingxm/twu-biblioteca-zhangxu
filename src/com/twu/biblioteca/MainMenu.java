package com.twu.biblioteca;

/**
 * Created by xuzhang on 3/4/15.
 */
public class MainMenu {
    public static final int SHOW_BOOK_LIST_OPTION = 1;
    public static final int CHECKOUT_BOOK_OPTION = 2;
    public static final int RETURN_BOOK_OPTION = 3;
    public static final int SHOW_MOVIE_LIST_OPTION = 4;
    public static final int CHECKOUT_MOVIE_OPTION = 5;

    public static void show() {
        System.out.println("Main Menu(select one options below, such as 1 or 2):");
        System.out.println(SHOW_BOOK_LIST_OPTION + ": Display Book List");
        System.out.println(CHECKOUT_BOOK_OPTION + ": Checkout Book");
        System.out.println(RETURN_BOOK_OPTION + ": Return Book");
        System.out.println(SHOW_MOVIE_LIST_OPTION + ": Show Movie List");
        System.out.println(CHECKOUT_MOVIE_OPTION + ": Checkout Movie(type movie name)");
    }

    public static void invalidOptionPromptMessage() {
        System.out.println("Select an invalid option, retry please:");
    }
}
