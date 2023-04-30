package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class RentalStore {
    Scanner scanner = new Scanner(System.in);

    private long numberOfCustomers = 0;
    private long numberOfItems = 0;

    private ArrayList<Item> items;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals = new ArrayList<>();
    private ArrayList<Customer> revokedCustomers = new ArrayList<>();

    RentalStore (ArrayList<Item> items, ArrayList<Customer> customers) {
        this.customers = customers;
        numberOfCustomers = customers.toArray().length;
        this.items = items;
        numberOfItems = items.toArray().length;
    }

    public void register (Customer customer) {
        customers.add(customer); // register a new customer
        revokedCustomers.remove(customer);
    }

    public ArrayList<Item> getAvailableItems () {
        ArrayList<Item> availableItems = new ArrayList<>();
        for (var i: items) {
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

    public Item getItemById (int id) {
        for (var m: items) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    private void addItem(Item item) {
        items.add(item); // add a movie to the list off available movies
        item.setAvailable(true);
    }

    private void removeItem(Item item) {
        items.remove(item); // remove a movie from the list of available movies
        item.setAvailable(false);
    }

    public void rentItem (Item item, Customer customer) {
        if (!customer.isSuspended()) {
            removeItem(item);
            rentals.add(new Rental(item, customer));
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
            addItem(rental.getItem());
            rentals.remove(rental);
        }
    }

    public ArrayList<Rental> getRentals () {
        return rentals;
    }

    public long getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public long getNumberOfItems() {
        return numberOfItems;
    }

}
