package com.kodilla.good.patterns.flightS;

import java.util.Set;

public class FlightsDb {
    private Set<Flight> availableFlights;

    public FlightsDb(Set<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }



    public Set<Flight> getAvailableFlights() {
        return availableFlights;
    }
}
