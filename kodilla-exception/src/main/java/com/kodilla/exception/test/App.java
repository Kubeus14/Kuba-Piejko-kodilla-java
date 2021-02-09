package com.kodilla.exception.test;

public class App {
    public static void main(String[] args) {
        Flight trip1 = new Flight("Balice", "Modlin");
        Flight trip2 = new Flight("Pyrzowice", "Lawica");
        Flight trip3 = new Flight("Okęcie", "Lublinek");
        Flight trip4 = new Flight("Okęcie", "Lawica");
        Flight trip5 = new Flight("Balice", "Pyrzowice");

        FlightLogistics flightLogistics = new FlightLogistics();

        try {
            boolean ifTrip1 = flightLogistics.findFlight(trip1);
            System.out.println("Flight from Balice to Modlin: " +ifTrip1 );
        } catch (RouteNotFoundException e) {
            System.out.println("Search correct flight.");
        }

        try {
            boolean ifTrip2 = flightLogistics.findFlight(trip2);
            System.out.println("Flight from Pyrzowice to Lawica: " + ifTrip2);
        } catch (RouteNotFoundException e) {
            System.out.println("Search correct flight.");
        }

        try {
            boolean ifTrip3 = flightLogistics.findFlight(trip3);
            System.out.println("Flight from Okęcie to Lublinek: " + ifTrip3);
        } catch (RouteNotFoundException e) {
            System.out.println("Search correct flight.");
        }
        try {
            boolean ifTrip4 = flightLogistics.findFlight(trip4);
            System.out.println("Flight from Okęcie to Lawica: " + ifTrip4);
        } catch (RouteNotFoundException e) {
            System.out.println("Search correct flight.");
        }
        try {
            boolean ifTrip5 = flightLogistics.findFlight(trip5);
            System.out.println("Flight from Balice to Pyrzowice: " + ifTrip5);
        } catch (RouteNotFoundException e) {
            System.out.println("Search correct flight.");
        }

    }
}
