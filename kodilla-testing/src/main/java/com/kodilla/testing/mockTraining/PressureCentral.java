package com.kodilla.testing.mockTraining;

import java.util.HashMap;
import java.util.Map;

public class PressureCentral {
    private Pascals pascals;

    public PressureCentral(Pascals pascals) {
        this.pascals = pascals;
    }
    public Map<String,Double> calculatePascals(){
        Map<String,Double> resultTab = new HashMap<>();
        for(Map.Entry<String,Double> pascal : pascals.getResults().entrySet()){
            resultTab.put(pascal.getKey(),pascal.getValue());
        }return resultTab;
    }
}
