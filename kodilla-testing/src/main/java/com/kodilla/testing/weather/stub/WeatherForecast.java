package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }


    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double averageTemp() {
        double sum = 0.0;
        double avg = 0.0;
        double avr = 0.0;
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue());
            avg = sum += temperature.getValue();

        }
        avr = avg /= resultMap.size();
        System.out.println(avr);
        return avr;
    }

    public double medianaTemp() {

        List<Double> tempList = new ArrayList<>();

        for(Double temperature : tempList){
            tempList.add(25.5);
            tempList.add(26.2);
            tempList.add(24.8);
            tempList.add(25.2);
            tempList.add(26.1);
        }
        Collections.sort(tempList);
        int medium = tempList.size()/2;
        double mediana = tempList.get(medium);


        return mediana;
    }
}
