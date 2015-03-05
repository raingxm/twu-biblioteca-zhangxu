package com.twu.biblioteca;

/**
 * Created by xuzhang on 3/5/15.
 */
public class User {
    private String name;
    private String libraryNum;
    private String password;

    public User(String name, String libraryNum, String password) {
        this.name = name;
        this.libraryNum = libraryNum;
        this.password = password;
    }

    public boolean checkUser(String libraryNum, String userPassword) {
        return this.libraryNum.equals(libraryNum) && this.password.equals(userPassword);
    }
}
