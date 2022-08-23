package com.encora.travelbooking;

import com.encora.travelbooking.domain.BusTicket;
import com.encora.travelbooking.domain.PlaneTicket;
import com.encora.travelbooking.domain.TrainTicket;
import com.encora.travelbooking.domain.TravelClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();
        TrainTicket trainTicket2 = new TrainTicket(123L, "London", "Edinburgh", new BigDecimal("59.00"),
                LocalDateTime.of(2021, 9, 30, 16, 03),
                LocalDateTime.of(2022, 3, 7, 19, 03),
                TravelClass.FIRST, 3, 42);

        trainTicket2.upgrade();

        String[] providers = {"First Bus Company", "Second Bus Company"};

        BusTicket busTicket = new BusTicket(124L, "London", "Edinburgh", new BigDecimal("59.00"),
                LocalDateTime.of(2022, 3, 7, 16, 03),
                LocalDateTime.of(2022, 3, 7, 19, 03), providers);

        trainTicket2.cancel();
        busTicket.cancel();

    }

}
