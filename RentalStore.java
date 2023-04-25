package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static org.example.Utilities.dateReduction;

public class RentalStore {
    Scanner scanner = new Scanner(System.in);

    private ArrayList<Movie> movies;
    private ArrayList<Customer> customers;
    private ArrayList<Customer> revokedCustomers = new ArrayList<>();

    RentalStore (ArrayList<Movie> movies, ArrayList<Customer> customers) {
        this.movies = movies;
        this.customers = customers;
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
            Rental rental = new Rental(movie, customer);
        } else {
            System.out.println("Sorry, Your account has been suspended!" +
                    "\nYou cannot rent anything right now!");
        }
    }

    public void returnItem (Rental rental) {
        var fee = rental.calculateLateFee();
        rental.payLateFee(rental.getCustomer(), fee);
        addItem(rental.getMovie());

        if (rental.getCustomer().isSuspended()) {
            suspensionChecking(rental.getCustomer());
        }
    }

    private void suspensionChecking(Customer customer) {
        if (customer.isSuspended()) {
            if (dateReduction(new Date(), customer.getDeadline()) >= 0) {
                System.out.println("Your account is suspended!");
                System.out.print("Do you want to pay your fee? (Y/N) ");
                var answer = scanner.nextLine().toLowerCase().trim();

                if (answer.equals("y") && customer.getFund() >= customer.getPayment()) {
                    customer.addFund((-1) * customer.getPayment());
                    customer.setSuspended(false);

                } else if (!answer.equals("y")) {
                    System.out.println("Sorry, You don't have enough money!");
                }

            } else {
                revokedCustomers.add(customer);
                customers.remove(customer);
                System.out.println("Sorry but your account has been revoked!");
            }
        }
    }

}
