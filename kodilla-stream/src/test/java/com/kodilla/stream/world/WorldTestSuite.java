package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent europa = new Continent("Europa");
        Continent northAmerica = new Continent("NorthAmerica");

        Country italy = new Country("Italy");
        Country france = new Country("France");
        Country slovakia = new Country("Slovakia");
        Country sweden = new Country("Sweden");
        Country usa = new Country("USA");
        Country mexico = new Country("Mexico");
        Country canada = new Country("Canada");

        world.addContinent(europa);
        world.addContinent(northAmerica);


        europa.addCountry(italy);
        europa.addCountry(france);
        europa.addCountry(slovakia);
        europa.addCountry(sweden);
        northAmerica.addCountry(usa);
        northAmerica.addCountry(mexico);
        northAmerica.addCountry(canada);



        //When

        BigDecimal totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal totalPeopleExpected = new BigDecimal("7000007");
        Assertions.assertEquals(totalPeopleExpected, totalPeople);
    }
}
