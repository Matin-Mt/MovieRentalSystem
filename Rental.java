package org.example;

import java.util.Date;
import java.util.Scanner;

public class Rental {
    Scanner scanner = new Scanner(System.in);

    private int id;
    private int counter = 1;
    private Movie movie;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;

    public Rental(Movie movie, Customer customer) {
        this.id = counter++;
        this.movie = movie;
        this.customer = customer;
        setRentalDate();
        setReturnDate();
    }

    public double calculateLateFee() {
        var currentDate = new Date();

        return (((currentDate.getYear() - returnDate.getYear()) * 365) +
                ((currentDate.getMonth()) - returnDate.getMonth() * 30) +
                (currentDate.getDate() - returnDate.getDate())) * movie.getFee();
    }





    public void payLateFee(Customer customer, double fee) {
        System.out.println("Payable Amount: " + fee);
        System.out.print("\nDo you want to pay? (Y/N) ");
        var answer = scanner.next().toLowerCase().trim();

        if (answer.equals("y") || answer.equals("yes") ) {
            if (customer.getFund() < fee) {
                System.out.println("Sorry, You don't have enough money!" +
                        "\nYou'll have to pay the fee within 3 days otherwise your membership will be revoked!");
                ////////////////////////////////////////////
                customer.setPayment(fee);

                var date = new Date();
                date.setDate(date.getDate() + 3); // update suspended Members every time date has been updated
                customer.setDeadline(date);
                customer.setSuspended(true);
                ////////////////////////////////////////////
            } else {
                customer.addFund((-1) * fee);
                System.out.println("Thanks for your payment!");
            }
        }
    }






    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    private void setRentalDate() {
        rentalDate = new Date();
    }

    public Date getReturnDate() {
        return returnDate;
    }

    private void setReturnDate() {
        returnDate = new Date(rentalDate.getYear(), rentalDate.getMonth(), rentalDate.getDate() + 4);
    }
}

