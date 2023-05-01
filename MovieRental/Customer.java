package org.example.MovieRental;

import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int id;
    private int counter = 1;
    private String name;
    private String email;
    private String phone;
    private String address;
    private ArrayList<Rental> rentals;

    private double fund = 0;
    private double payment = 0;
    private Date deadline;
    private boolean isSuspended = false;

    public Customer (String name) {
        this(name, null, null, null);
    }

    public Customer (String name, String phone) {
        this(name, null, phone, null);
    }

    public Customer (String name, String phone, String address) {
        this(name, null, phone, address);
    }

    public Customer(String name, String email, String phone, String address) {
        id = counter++;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        rentals = new ArrayList<>();
    }

    public void addFund (double fund) {
        this.fund += fund;
    }

    public double getFund () {
        return fund;
    }

    public void setPayment (double payment) {
        this.payment = payment;
    }

    public double getPayment () {
        return payment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline (Date deadline) {
        this.deadline = deadline;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }
}
