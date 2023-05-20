package org.example;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<Game> games = new ArrayList<>();
    public static ArrayList<Movie> movies = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Rental> rentals = new ArrayList<>();

    public static void main(String[] args) {
        Convertor.jsonToJava();
        RentalStore<Book> bookRentalStore = new RentalStore<>(Main.books, Main.customers);
        RentalStore<Game> gameRentalStore = new RentalStore<>(Main.games, Main.customers);
        RentalStore<Movie> movieRentalStore = new RentalStore<>(Main.movies, Main.customers);

        Customer John_Smith = Main.customers.get(0);
        Customer Emily_Johnson = Main.customers.get(1);
        Customer Michael_Brown = Main.customers.get(2);

        bookRentalStore.rentItem(Main.books.get(2), John_Smith);
        bookRentalStore.rentItem(Main.books.get(5), John_Smith);

        bookRentalStore.rentItem(Main.books.get(0), Emily_Johnson);
        bookRentalStore.rentItem(Main.books.get(3), Emily_Johnson);

        bookRentalStore.rentItem(Main.books.get(8), Michael_Brown);
        gameRentalStore.rentItem(Main.games.get(3), Michael_Brown);

        Convertor.javaToJson();
    }
}