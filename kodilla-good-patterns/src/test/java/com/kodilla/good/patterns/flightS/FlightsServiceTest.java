package com.kodilla.good.patterns.flightS;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
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
        Set<Flight> result1 = flightsService.availableFlightsFrom("KRK");
        Set<Flight> result2 = flightsService.availableFlightsFrom("WAR");
        Set<Flight> result3 = flightsService.availableFlightsFrom("POZ");
        //Then
        assertEquals(result1.size(),2);
        assertEquals(result2.size(),1);
        assertEquals(result3.size(),0);
    }
    @Test
    void testAvailableFlightsTo(){
        //Given
        Set<Flight> availableFlights = new HashSet<>();
        availableFlights.add(new Flight("POZ","KRK"));
        availableFlights.add(new Flight("WAR","KRK"));
        availableFlights.add(new Flight("WAR","POZ"));
        FlightsDb flightsDb = new FlightsDb(availableFlights);
        FlightsService flightsService = new FlightsService(flightsDb);
        //When
        Set<Flight> rsl1 = flightsService.availableFlightsTo("POZ");
        Set<Flight> rsl2 = flightsService.availableFlightsTo("KRK");
        Set<Flight> rsl3 = flightsService.availableFlightsTo("WAR");
        //Then
        assertEquals(rsl1.size(),1);
        assertEquals(rsl2.size(),2);
        assertEquals(rsl3.size(),0);
    }
    @Test
    void testAvailableConnectingFlights(){
        //Given
        Set<Flight> availableFlights = new HashSet<>();
        availableFlights.add(new Flight("KRK","POZ"));
        availableFlights.add(new Flight("WAR","KRK"));
        availableFlights.add(new Flight("POZ","WAR"));
        FlightsDb flightsDb = new FlightsDb(availableFlights);
        FlightsService flightsService = new FlightsService(flightsDb);
        //When
        Set<List<Flight>> connection1 = flightsService.availableConnectingFlights("KRK","WAR");
        Set<List<Flight>> connection2 = flightsService.availableConnectingFlights("KRK","POZ");
        Set<List<Flight>> connection3 = flightsService.availableConnectingFlights("POZ","WAR");
        //Then
        assertEquals(connection1.size(),1);
        assertEquals(connection2.size(),0);
        assertEquals(connection3.size(),0);
    }

}