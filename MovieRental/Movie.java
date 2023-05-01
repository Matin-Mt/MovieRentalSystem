package org.example.MovieRental;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
    private int id;
    private int counter = 1;
    private String title;
    private String genre;
    private String director;
    private ArrayList<String> cast;
    private Date releaseDate;
    private boolean isAvailable;
    private double fee;

    public Movie(String title, String genre, String director, ArrayList<String> cast,
                 Date releaseDate, double Fee) {
        this.id = counter++;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.cast = new ArrayList<>(cast);
        this.releaseDate = releaseDate;
        this.fee = Fee;
    }

    public Movie(String title, String genre, Date releaseDate, double fee) {
        this(title, genre, null, null, releaseDate, fee);
    }

    public Movie(String title, String genre, String director, Date releaseDate, double fee) {
        this(title, genre, director, null, releaseDate, fee);
    }

    public Movie(String title, String genre, String director, ArrayList<String> cast,
                 Date releaseDate) {
        this(title, genre, director, cast, releaseDate, 0);
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable (boolean status) {
        this.isAvailable = status;
    }
}
