package com.twu.biblioteca;

/**
 * Created by xuzhang on 3/2/15.
 */
public class Book {
    private String name;

    private String author;

    private int publishYear;

    private boolean borrow;

    public boolean isBorrowOut() {
        return borrow;
    }

    public void borrowOut() {
        borrow = true;
    }

    public void returnBack() {
        borrow = false;
    }

    public String getName() {
        return name;
    }

    public Book(String name, String author, int publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.borrow = false;
    }

    @Override
    public String toString() {
        return name + " | " + author + " | " + publishYear;
    }
}
