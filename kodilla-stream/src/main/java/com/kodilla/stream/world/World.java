package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<Continent> listContinentsOnWorld = new ArrayList<>();

    public boolean addContinent(Continent continent){
        return listContinentsOnWorld.add(continent);
    }
    public BigDecimal getPeopleQuantity(){
        BigDecimal peopleQtyOnTheWorld = listContinentsOnWorld.stream()
                .flatMap(continent -> continent.getListCountriesOnContinent().stream())
                .distinct()
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum,country)->sum=sum.add(country));
        return peopleQtyOnTheWorld;
    }
}
