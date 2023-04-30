package org.example;

import java.util.Date;

public class Game extends Item {
    private String genre;
    private String creator;
    private String company;

    public Game(String title, String genre, String creator, String company, Date releaseDate, double fee) {
        super(title, genre, releaseDate, fee);
        this.creator = creator;
        this.company = company;
    }

    public Game(String title, String genre, String creator, String company, Date releaseDate) {
        this(title, genre, creator, company, releaseDate, 0);
    }

    public Game(String title, String genre, Date releaseDate) {
        this(title, genre, "Unknown", "Unknown", releaseDate, 0);
    }

    public String getCreator() {
        return creator;
    }

    public String getCompany() {
        return company;
    }
}