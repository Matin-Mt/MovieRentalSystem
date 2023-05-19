package org.example;

import java.time.LocalDate;

public class Game extends Item {
    private String director;
    private double gameRate;
    private String aboutGame;
    private String manufacturer;

    public Game(long id, String title, String genre, LocalDate releaseDate, boolean isAvailable,
                String director, double gameRate, String aboutGame, String manufacturer) {
        super(id, title, genre, releaseDate, isAvailable);
        this.director = director;
        this.gameRate = gameRate;
        this.aboutGame = aboutGame;
        this.manufacturer = manufacturer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getGameRate() {
        return gameRate;
    }

    public void setGameRate(double gameRate) {
        this.gameRate = gameRate;
    }

    public String getAboutGame() {
        return aboutGame;
    }

    public void setAboutGame(String aboutGame) {
        this.aboutGame = aboutGame;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}