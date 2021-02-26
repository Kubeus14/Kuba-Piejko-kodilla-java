package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherForecastTestSuite{
    @Mock
    private Temperatures temperaturesMock;
    @BeforeEach
    public void before(){
        System.out.println("Test case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test case: after");
    }
    @Test
    void testCalculateForecastWithMock(){
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów",25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5,quantityOfSensors);
    }
    @Test
    void testAverageTempWithMock(){
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów",25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double avTem = weatherForecast.averageTemp();
        //Then
        assertEquals(25.56,avTem);


    }
    @Test
    void testMedianaTempWithMock(){
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów",25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double medTm = weatherForecast.medianaTemp();
        //Then
        assertEquals(25.5,medTm);
    }
}