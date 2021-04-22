package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent{
    private final String continentName;
    private final List<Country> listCountriesOnContinent = new ArrayList<>();

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }
    public List<Country> getListCountriesOnContinent(){
        return new ArrayList<>(listCountriesOnContinent);
    }
    public boolean addCountry(Country country){
        return listCountriesOnContinent.add(country);
    }
}
