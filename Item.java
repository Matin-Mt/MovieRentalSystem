package org.example;

import java.util.Date;

public class Item {
    private int id;
    private int counter = 1;
    private String title;
    private Date releaseDate;
    private boolean isAvailable;
    private String genre;
    private double fee;

    public Item(String title, String genre, Date releaseDate, double fee) {
        this.id = counter++;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.fee = fee;
        isAvailable = true;
    }

    public Item(String title, String genre, Date releaseDate) {
        this(title, genre, releaseDate, 0);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable (boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getGenre() {
        return genre;
    }

}
