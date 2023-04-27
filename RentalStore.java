package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class RentalStore {
    Scanner scanner = new Scanner(System.in);

    private long numberOfCustomers = 0;
    private long numberOfMovies = 0;

    private ArrayList<Movie> movies;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals = new ArrayList<>();
    private ArrayList<Customer> revokedCustomers = new ArrayList<>();

    RentalStore (ArrayList<Movie> movies, ArrayList<Customer> customers) {
        this.customers = customers;
        numberOfCustomers = customers.toArray().length;
        this.movies = movies;
        numberOfMovies = movies.toArray().length;
    }

    public void register (Customer customer) {
        customers.add(customer); // register a new customer
        revokedCustomers.remove(customer);
    }

    public ArrayList<Movie> getAvailableItems () {
        ArrayList<Movie> availableItems = new ArrayList<>();
        for (var i: movies) {
            if (i.isAvailable()) {
                availableItems.add(i);
            }
        }
        return availableItems;
    }

    public Customer getCustomerById (int id) { // if id doesn't exist it will return null
        for (var c: customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Movie getItemById (int id) {
        for (var m: movies) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    private void addItem(Movie movie) {
        movies.add(movie); // add a movie to the list off available movies
        movie.setAvailable(true);
    }

    private void removeItem(Movie movie) {
        movies.remove(movie); // remove a movie from the list of available movies
        movie.setAvailable(false);
    }

    public void rentItem (Movie movie, Customer customer) {
        if (!customer.isSuspended()) {
            removeItem(movie);
            rentals.add(new Rental(movie, customer));
        } else {
            System.out.println("Sorry, Your account has been suspended!" +
                    "\nYou cannot rent anything right now!");
        }
    }

    public void returnItem (Rental rental) {
        if (rental.getCustomer().isSuspended()) {
            System.out.println("something"); ///////////////////////////////////////////
        } else {
            var fee = rental.calculateLateFee();
            rental.payLateFee(rental.getCustomer(), fee);
            addItem(rental.getMovie());
            rentals.remove(rental);
        }
    }

    public ArrayList<Rental> getRentals () {
        return rentals;
    }

    public long getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public long getNumberOfMovies() {
        return numberOfMovies;
    }

}
