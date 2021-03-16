package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent{
   private final List<Country> listCountriesOnContinent = new ArrayList<>();
   private final String continentName;

    public Continent(String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getListCountriesOnContinent() {
        return listCountriesOnContinent;
    }

    public String getContinentName() {
        return continentName;
    }
    public boolean addCountry(Country country){
        return listCountriesOnContinent.add(country);
    }
}
