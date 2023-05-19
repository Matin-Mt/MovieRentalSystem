package org.example;

import java.util.ArrayList;

public class RentalStore {
    private long numberOfCustomers = 0;
    private long numberOfItems = 0;

    private ArrayList<Item> items;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals = new ArrayList<>();

    RentalStore (ArrayList<Item> items, ArrayList<Customer> customers) {
        this.customers = customers;
        numberOfCustomers = customers.toArray().length;
        this.items = items;
        numberOfItems = items.toArray().length;
    }

    public void register (Customer customer) {
        customers.add(customer);
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
        rentals.add(new Rental(item, customer));
    }

    public void returnItem (Rental rental) {
        addItem(rental.getItem());
        rentals.remove(rental);
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
