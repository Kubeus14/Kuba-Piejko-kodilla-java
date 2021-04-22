package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country{
    private final String countryName;
    private final BigDecimal peopleQuantity;

    public Country(final String countryName,final BigDecimal peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }
    public Country(final String countryName){
        this(countryName,new BigDecimal("1000001"));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {
        return countryName.hashCode();
    }
    public BigDecimal getPeopleQuantity(){
        return peopleQuantity;
    }
}