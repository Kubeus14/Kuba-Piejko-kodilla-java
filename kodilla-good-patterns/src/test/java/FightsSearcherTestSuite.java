import com.kodilla.good.patterns.flightS.Flight;
import com.kodilla.good.patterns.flightS.FlightsDb;
import com.kodilla.good.patterns.flightS.FligthsService;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FightsSearcherTestSuite {
    private static FligthsService flightsService;
    private static FlightsDb flightsDbMock;
    private static Set<Flight> availableFlights;

    @BeforeClass
    public static void beforeClass() {
        flightsDbMock = mock(FlightsDb.class);
        flightsService = new FligthsService(flightsDbMock);
        availableFlights = new HashSet<>();
        availableFlights.add(new Flight("WRO", "WAR"));
        availableFlights.add(new Flight("WAR", "GDA"));
        availableFlights.add(new Flight("WRO", "NYC"));
        availableFlights.add(new Flight("GDA", "NYC"));
        availableFlights.add(new Flight("WAR", "NYC"));
        availableFlights.add(new Flight("WRO", "GDA"));
    }

    @Test
    public void availableFlightsFromTest() {
        //Given
        String departureAirport = "WRO";
        Set<Flight> expected = new HashSet<>();
        expected.add(new Flight("WRO", "WAR"));
        expected.add(new Flight("WRO", "NYC"));
        expected.add(new Flight("WRO", "GDA"));
        //When
        when(flightsDbMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsFrom(departureAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void noAvailableFlightsFromTest() {
        //Given
        String departureAirport = "NYC";
        Set<Flight> expected = new HashSet<>();
        //When
        when(flightsDbMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsFrom(departureAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void availableFlightsToTest() {
        //Given
        String arrivalAirport = "NYC";
        Set<Flight> expected = new HashSet<>();
        expected.add(new Flight("WRO", "NYC"));
        expected.add(new Flight("GDA", "NYC"));
        expected.add(new Flight("WAR", "NYC"));
        //When
        when(flightsDbMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsTo(arrivalAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void noAvailableFlightsToTest() {
        //Given
        String arrivalAirport = "WRO";
        Set<Flight> expected = new HashSet<>();
        //When
        when(flightsDbMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsTo(arrivalAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void availableConnectingFlightsTest() {
        //Given
        String departureAirport = "WRO";
        String arrivalAirport = "NYC";
        Set<List<Flight>> expected = new HashSet<>();

        List<Flight> wroWarWarNyc = new ArrayList<>();
        wroWarWarNyc.add(new Flight("WRO", "WAR"));
        wroWarWarNyc.add(new Flight("WAR", "NYC"));

        expected.add(wroWarWarNyc);

        List<Flight> wroGdaGdaNyc = new ArrayList<>();
        wroGdaGdaNyc.add(new Flight("WRO", "GDA"));
        wroGdaGdaNyc.add(new Flight("GDA", "NYC"));

        expected.add(wroGdaGdaNyc);
        //When
        when(flightsDbMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<List<Flight>> result = flightsService.availableConnectingFlights(departureAirport, arrivalAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void noAvailableConnectingFlightsTest() {
        //Given
        String departureAirport = "NYC";
        String arrivalAirport = "GDA";
        Set<List<Flight>> expected = new HashSet<>();

        //When
        when(flightsDbMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<List<Flight>> result = flightsService.availableConnectingFlights(departureAirport, arrivalAirport);
        //Then
        Assert.assertEquals(expected, result);
    }
}
