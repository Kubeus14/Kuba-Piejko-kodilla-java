package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherForecastTestSuite{
    @Mock
    private Temperatures temperaturesMock;
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
        Assertions.assertEquals(5,quantityOfSensors);
    }
    @Test
    void testAverageTempWithStub(){
        //Given
        double sum = 0.0;
        Temperatures temperatures = mock(Temperatures.class);
        Map<String,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów",25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        for(Map.Entry<String,Double> temper : temperatures.getTemperatures().entrySet()){
            temperaturesMap.put(temper.getKey(),temper.getValue());
            sum+=temper.getValue();
            double avr = sum/(double)temperaturesMap.size();
            System.out.println(avr);
        when(temperatures.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
            double avrTest = weatherForecast.averageTemp();
        //Then
        Assertions.assertEquals(avr,avrTest);
        }
    }
}