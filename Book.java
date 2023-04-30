package org.example;

import java.util.Date;

public class Book extends Item {
    private String author;

    public Book(String title, String author, String genre, Date releaseDate, double fee) {
        super(title, genre, releaseDate, fee);
        this.author = author;
    }

    public Book(String title, String author, String genre, Date releaseDate) {
        this(title, author, genre, releaseDate, 0);
    }

    public String getAuthor() {
        return author;
    }
}
