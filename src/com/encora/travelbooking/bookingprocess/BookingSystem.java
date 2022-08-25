package com.encora.travelbooking.bookingprocess;

import com.encora.travelbooking.domain.TravelTicket;

public interface BookingSystem {

    public void setTravelTicket(TravelTicket ticket);
    public void requestBooking();
    public boolean getStatus();
    public boolean cancel();

    public static String getVersion() {
        return "Version 2";
    }

    //This is a helper method
    public static BookingSystem of(TravelTicket ticket) {
        BookingSystem bookingSystem = new CheapTravelBookingSystem();
        bookingSystem.setTravelTicket(ticket);
        return bookingSystem;
    }

    //The 'default' keyword here, means that this code exists in the interface
    // and it doesn't have to be overridden by the implemented classes, BUT it can be.
    public default boolean isExpired() {
        return true;
    }

}
