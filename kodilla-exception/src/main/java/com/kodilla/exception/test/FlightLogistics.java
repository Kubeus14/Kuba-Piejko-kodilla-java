package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightLogistics {

    private final Map<String, Boolean> airportArea;

    public FlightLogistics() {
        airportArea = officeAirport();
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        return searchAirport(flight.getArrivalAirport()) && searchAirport(flight.getDepartureAirport());
    }

    private boolean searchAirport(String placeOfAirport) throws RouteNotFoundException{
        if (airportArea.containsKey(placeOfAirport)) {
            return airportArea.get(placeOfAirport);
        }else{
            throw new RouteNotFoundException("This airport isn't in database");
        }
    }

    private Map<String, Boolean> officeAirport() {
        Map<String, Boolean> officeAirport = new HashMap<>();
        officeAirport.put("Balice", true);
        officeAirport.put("Pyrzowice", false);
        officeAirport.put("Okęcie", true);
        officeAirport.put("Modlin", true);
        officeAirport.put("Ławica", false);
        officeAirport.put("Lublinek", true);

        return officeAirport;
    }
}
