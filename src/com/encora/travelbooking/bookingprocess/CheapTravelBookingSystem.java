package com.encora.travelbooking.bookingprocess;

import com.encora.travelbooking.domain.TravelTicket;

public class CheapTravelBookingSystem implements BookingSystem{

    @Override
    public void setTravelTicket(TravelTicket ticket) {
        System.out.println("Cheap Travel has received ticket " + ticket);
    }

    @Override
    public void requestBooking() {
        System.out.println("Cheap Travel has received a booking request");
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public boolean cancel() {
        return false;
    }
}
