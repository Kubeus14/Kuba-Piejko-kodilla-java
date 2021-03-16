package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<Continent> listContinentsInWorld = new ArrayList<>();
    public boolean addContinent(Continent continent){
        return listContinentsInWorld.add(continent);
    }
    public BigDecimal getPeopleQuantity(){
        BigDecimal peopleQuantityOnTheWorld = listContinentsInWorld.stream()
                .flatMap(continent -> continent.getListCountriesOnContinent().stream())
                .distinct()
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum,country)->sum.add(country));
        return peopleQuantityOnTheWorld;

    }
}
