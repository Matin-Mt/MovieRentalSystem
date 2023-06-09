package org.example;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private ArrayList<Rental> rentals;

    public Customer(int id, String name, String email, String phone, String address,
                    ArrayList<Rental> rentals) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.rentals = rentals;
    }

    public void addRental(Rental rental) {
        if (this.rentals == null)
            this.rentals = new ArrayList<>();
        this.rentals.add(rental);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(ArrayList<Rental> rentals) {
        this.rentals = rentals;
    }
}
