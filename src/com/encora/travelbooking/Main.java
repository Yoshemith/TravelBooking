package com.encora.travelbooking;

import com.encora.travelbooking.bookingprocess.BookingSystem;
import com.encora.travelbooking.bookingprocess.CheapTravelBookingSystem;
import com.encora.travelbooking.bookingprocess.EnjoyableToursBookingSystem;
import com.encora.travelbooking.domain.*;
import com.encora.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws InvalidTravelDurationException {
        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();
        TrainTicket trainTicket2 = null;
        try {
            trainTicket2 = new TrainTicket(123L, "London", "Edinburgh", new BigDecimal("59.00"),
                    LocalDateTime.of(2022, 9, 30, 16, 03),
                    LocalDateTime.of(2023, 3, 7, 19, 03),
                    TravelClass.FIRST, 3, 42);
            trainTicket2.upgrade();
            trainTicket2.cancel();
        } catch (InvalidTravelDurationException e) {
            e.printStackTrace();
        }

        //String[] providers = {"First Bus Company", "Second Bus Company"};

        ArrayList<String> providers = new ArrayList<>();
        providers.add("First Bus Company");
        providers.add("Second Bus Company");
        providers.add("Third Bus Company");

        System.out.println(providers.size());
        System.out.println(providers);

        BusTicket busTicket = null;
        busTicket = new BusTicket(124L, "London", "Edinburgh", new BigDecimal("59.00"),
                    LocalDateTime.of(2022, 9, 30, 16, 03),
                    LocalDateTime.of(2023, 3, 7, 19, 03), providers);

        BusTicket busTicket2 = new BusTicket(125L, "New York", "Boston", new BigDecimal("59.00"),
                LocalDateTime.of(2022, 9, 30, 16, 03),
                LocalDateTime.of(2023, 3, 7, 19, 03), providers);

        BusTicket busTicket3 = new BusTicket(126L, "Paris", "Someplace", new BigDecimal("59.00"),
                LocalDateTime.of(2022, 9, 30, 16, 03),
                LocalDateTime.of(2023, 3, 7, 19, 03), providers);

        ArrayList<TravelTicket> tickets = new ArrayList<>();
        //HashSet<TravelTicket> tickets = new HashSet<>();

        //List<TravelTicket> tickets = new ArrayList<>(); //This line fo code is implementing the 'List' interface. But is still working with the ArrayList implementation

        tickets.add(busTicket);
        tickets.add(busTicket2);
        tickets.add(busTicket3);
        tickets.add(busTicket);
        tickets.add(busTicket2);
        tickets.add(busTicket3);
        tickets.add(trainTicket2);

//        System.out.println(tickets.get(1));
//
//        for (int i = 0; i < tickets.size(); i++) {
//            System.out.println(tickets.get(i));
//        }

        //we can use for each in hashsets.

        //With polymorphism, we can use the parent class type to refer to any children (subclasses).
        for (TravelTicket b: tickets) {
            System.out.println(b);
        }

        TravelTicket foundTicket = tickets.get(2);
        System.out.println(foundTicket);

        if (foundTicket instanceof BusTicket) {
            System.out.println("This is a bus Ticket");
            BusTicket foundBusTicket = (BusTicket) foundTicket;
            System.out.println(foundBusTicket.getPermittedProviders());
        } else if (foundTicket instanceof TrainTicket) {
            System.out.println("This is a Train Ticket");
        } else {
            System.out.println("This is a plane ticket");
        }

        BusTicket busTicket4 = new BusTicket(foundTicket, providers);

        //We cannot instantiate it because is an interface.
        //BookingSystem bookingSystem = new EnjoyableToursBookingSystem();
        //We can have multiple implementations, we can swap between implementations and the code will still run just fine.
        BookingSystem bookingSystem = new CheapTravelBookingSystem();


        //But, we can access its methods.
        bookingSystem.setTravelTicket(busTicket4);
        bookingSystem.requestBooking();
        System.out.println("The booking status is " + bookingSystem.getStatus());

        //Only Java 17 or above, the pattern matching in java 17 way is below
        //We can give the new variable name in the same line, in this case 'bt' as you can see.
//        if (foundTicket instanceof BusTicket bt) {
//            System.out.println(bt.getPermittedProviders());
//        }

        //using a static method in an interface
        System.out.println(BookingSystem.getVersion());

        //This is another way of instantiating if we create static methods in an interface.
        BookingSystem bookingSystem2 = BookingSystem.of(trainTicket);

    }

}
