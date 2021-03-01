package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

class WeatherForecastTestSuite{
    @Test
    void testCalculateForecastWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        assertEquals(5,quantityOfSensors);
    }
    @Test
    void testAverageTempWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        double avrTemp = weatherForecast.averageTemp();
        //Then
        assertEquals(25.56,avrTemp);

    }
    @Test
    void testMedianaTempWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        double medTemp = weatherForecast.medianaTemp();
        //Then
        assertEquals(25.5,medTemp);
    }
}