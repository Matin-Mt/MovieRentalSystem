package org.example;

import org.example.Item;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Item {
    private String director;
    private ArrayList<String> cast;

    public Movie(String title, String genre, String director,
                 ArrayList<String> cast, Date releaseDate, double fee) {
        super(title, genre, releaseDate, fee);
        this.director = director;
        this.cast = new ArrayList<>(cast);
    }

    public Movie(String title, String genre, String director,
                 ArrayList<String> cast, Date releaseDate) {
        this(title, genre, director, cast, releaseDate, 0);
    }

    public String getDirector() {
        return director;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

}

