package org.example;

import java.util.ArrayList;

public class RentalStore <K extends Item> {
    private ArrayList<K> items;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals = new ArrayList<>();

    RentalStore (ArrayList<K> items, ArrayList<Customer> customers) {
        this.customers = customers;
        this.items = items;
    }

    public void register (Customer customer) {
        customers.add(customer);
        Main.customers.add(customer);
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

    public Customer getCustomerById (int id) {
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

    public void addNewItem(K item) {
        if (item instanceof Book)
            Main.books.add((Book) item);
        if (item instanceof Game)
            Main.games.add((Game) item);
        if (item instanceof Movie)
            Main.movies.add((Movie) item);

        items.add(item);
    }

    public void removeItem(K item) {
        if (item instanceof Book)
            Main.books.remove((Book) item);
        if (item instanceof Game)
            Main.games.remove((Game) item);
        if (item instanceof Movie)
            Main.movies.remove((Movie) item);

        items.remove(item);
    }

    public void rentItem (Item item, Customer customer) {
        Rental rental = new Rental(item, customer);
        Main.rentals.add(rental);
        rentals.add(rental);
        rental.getItem().setAvailable(false);
    }

    public void returnItem (Rental rental) {
        rentals.remove(rental);
        Main.rentals.remove(rental);
        rental.getItem().setAvailable(true);
    }

    public ArrayList<K> getItems() {
        return items;
    }

    public void setItems(ArrayList<K> items) {
        this.items = items;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(ArrayList<Rental> rentals) {
        this.rentals = rentals;
    }
}
