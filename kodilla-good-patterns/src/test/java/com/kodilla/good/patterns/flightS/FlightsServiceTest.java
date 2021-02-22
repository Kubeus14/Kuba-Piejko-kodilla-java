package com.kodilla.good.patterns.flightS;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightsServiceTest {

    @Test
    void testAvailableFlightsFrom(){
        //Given
        Set<Flight> availableFlights = new HashSet<>();
        availableFlights.add(new Flight("KRK","POZ"));
        availableFlights.add(new Flight("KRK","WAR"));
        availableFlights.add(new Flight("WAR","POZ"));
        FlightsDb flightsDb = new FlightsDb(availableFlights);
        FlightsService flightsService = new FlightsService(flightsDb);
        //When
        Set<Flight> result = flightsService.availableFlightsFrom("KRK");
        //Then
        assertEquals(result.size(),2);
    }

}