package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.util.StringUtils;

/**
 * Created by xuzhang on 3/4/15.
 */
public class MainMenu {
    public static final int SHOW_BOOK_LIST_OPTION = 1;
    public static final int CHECKOUT_BOOK_OPTION = 2;
    public static final int RETURN_BOOK_OPTION = 3;
    public static final int SHOW_MOVIE_LIST_OPTION = 4;
    public static final int CHECKOUT_MOVIE_OPTION = 5;
    public static final int SHOW_USER_INFO_OPTION = 6;

    public static void show() {
        System.out.println(StringUtils.MAIN_MENU_OPTION_CHOOSE);
        System.out.println(SHOW_BOOK_LIST_OPTION + StringUtils.MAIN_MENU_SHOW_BOOK_LIST_OPTION);
        System.out.println(CHECKOUT_BOOK_OPTION + StringUtils.MAIN_MENU_CHECK_BOOK_OPTION);
        System.out.println(RETURN_BOOK_OPTION + StringUtils.MAIN_MENU_RETURN_BOOK_OPTION);
        System.out.println(SHOW_MOVIE_LIST_OPTION + StringUtils.MAIN_MENU_SHOW_MOVIE_LIST_OPTION);
        System.out.println(CHECKOUT_MOVIE_OPTION + StringUtils.MAIN_MENU_CHECKOUT_MOVIE_OPTION);
        System.out.println(SHOW_USER_INFO_OPTION + StringUtils.MAIN_MENU_SHOW_USER_INFO_OPTION);
    }

    public static void invalidOptionPromptMessage() {
        System.out.println(StringUtils.MAIN_MENU_INVALID_INPUT_PROMPT);
    }
}
