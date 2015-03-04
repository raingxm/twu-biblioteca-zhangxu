package com.twu.biblioteca;

/**
 * Created by xuzhang on 3/5/15.
 */
public class User {
    private String name;
    private String password;

    public boolean checkUser(String username, String userPassword) {
        return name.equals(username) && password.equals(userPassword);
    }
}
