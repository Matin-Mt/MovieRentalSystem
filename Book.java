package org.example;

import java.util.Date;

public class Book extends Item {
    private String author;
    private String genre;

    public Book(String title, String author, String genre, Date releaseDate, double fee) {
        super(title, releaseDate, fee);
        this.author = author;
        this.genre = genre;
    }

    public Book(String title, String author, String genre, Date releaseDate) {
        this(title, author, genre, releaseDate, 0);
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
