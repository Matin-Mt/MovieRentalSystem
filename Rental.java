package org.example;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Rental {
    private long id;
    private static long counter = 1;
    private Item item;
    private Customer customer;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public Rental(Item item, Customer customer) {
        this.id = counter++;
        this.item = item;
        this.customer = customer;
        rentalDate = dateConvertor();
        setRentalDate(rentalDate.plusDays(4));
    }

    private LocalDate dateConvertor() {
        Instant instant = new Date().toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}

