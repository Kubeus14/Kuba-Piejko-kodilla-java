package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast{
    private Temperatures temperatures;
    public WeatherForecast(Temperatures temperatures){
        this.temperatures=temperatures;
    }
    public Map<String,Double> calculateForecast(){
        Map<String,Double> resultMap = new HashMap<>();
        for(Map.Entry<String,Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(),temperature.getValue()+1.0);
        }
        return resultMap;
    }
    public double averageTemp(){
        double sum = 0.0;
        Map<String,Double> resultMap = new HashMap<>();
        for(Map.Entry<String,Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(),temperature.getValue());
            sum+=temperature.getValue();
        }
        double avg = sum/(double)resultMap.size();
        System.out.println(avg);
        return avg;
    }
    public double medianaTemp(){
        List<Double> temps = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temps);
        int medium = temps.size()/2;
        double mediana = temps.get(medium);
        return mediana;
    }
}