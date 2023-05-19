package org.example;

import java.time.LocalDate;

public class Movie extends Item {
    private String director;
    private String cast;

    public Movie(long id, String title, String genre, LocalDate releaseDate, boolean isAvailable,
                 String director, String cast) {
        super(id, title, genre, releaseDate, isAvailable);
        this.director = director;
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
}

