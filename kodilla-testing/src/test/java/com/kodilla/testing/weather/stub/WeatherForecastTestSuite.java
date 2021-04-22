package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WeatherForecastTestSuite{
    @Test
    void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        int qtyOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5,qtyOfSensors);
    }
    @Test
    void testAverageTempWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        double avgTemp = weatherForecast.averageTemp();
        //Then
        assertEquals(25.56,avgTemp);
    }
    @Test
    void testMediumTempWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        double medTemp = weatherForecast.medianaTemps();
    }

}