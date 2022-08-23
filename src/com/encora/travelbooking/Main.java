package com.encora.travelbooking;

import com.encora.travelbooking.domain.BusTicket;
import com.encora.travelbooking.domain.PlaneTicket;
import com.encora.travelbooking.domain.TrainTicket;
import com.encora.travelbooking.domain.TravelClass;
import com.encora.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
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
        try {
            busTicket = new BusTicket(124L, "London", "Edinburgh", new BigDecimal("59.00"),
                    LocalDateTime.of(2022, 9, 30, 16, 03),
                    LocalDateTime.of(2023, 3, 7, 19, 03), providers);

        } catch (InvalidTravelDurationException e) {
            e.printStackTrace();
        }
        busTicket.cancel();

        PlaneTicket planeTicket = new PlaneTicket();

    }

}
