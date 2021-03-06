package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    @Mock
    private Temperatures temperaturesMock;

    @Test
    void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<String,Double> temperaturesMap=new HashMap<>();
        temperaturesMap.put("Rzeszów",25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int qtyOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5,qtyOfSensors);
    }
    @Test
    void testAverageTempWithMock(){
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
        double avgTmp = weatherForecast.averageTemp();
        //Then
        assertEquals(25.56,avgTmp);
    }
    @Test
    void testMedianaTempWithMock(){
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
        double mdTemp = weatherForecast.medianaTemps();
        //Then
        assertEquals(25.5,mdTemp);
    }
}