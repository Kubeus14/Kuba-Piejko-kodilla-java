package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStub();                     // [1]
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);    // [2]

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
    @Test
    void testAverageTempWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        double avrTemp = weatherForecast.averageTemp();
        //Then
        Assertions.assertEquals(25.56,avrTemp);
    }
    @Test
    void testMediumTempWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        double medianaTest = weatherForecast.medianaTemp();
        //Then
        Assertions.assertEquals(25.5,medianaTest);
    }
}



