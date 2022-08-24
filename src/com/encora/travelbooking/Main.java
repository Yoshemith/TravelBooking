package com.encora.travelbooking;

import com.encora.travelbooking.domain.BusTicket;
import com.encora.travelbooking.domain.PlaneTicket;
import com.encora.travelbooking.domain.TrainTicket;
import com.encora.travelbooking.domain.TravelClass;
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

        //ArrayList<BusTicket> busTickets = new ArrayList<>();
        HashSet<BusTicket> busTickets = new HashSet<>();
        busTickets.add(busTicket);
        busTickets.add(busTicket2);
        busTickets.add(busTicket3);
        busTickets.add(busTicket);
        busTickets.add(busTicket2);
        busTickets.add(busTicket3);

//        System.out.println(busTickets.get(1));
//
//        for (int i = 0; i < busTickets.size(); i++) {
//            System.out.println(busTickets.get(i));
//        }

        //we can use for each in hashsets.
        for (BusTicket b: busTickets) {
            System.out.println(b.getBookingRef());
        }

        PlaneTicket planeTicket = new PlaneTicket();

    }

}
