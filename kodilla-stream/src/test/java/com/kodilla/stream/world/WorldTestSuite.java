package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.testng.AssertJUnit.assertEquals;

public class WorldTestSuite{
    @Test
    void testGetPeopleQuantity(){
        //Given
        World world = new World();
        Continent northAmerica = new Continent("North America");

        Country usa = new Country("USA");
        Country canada = new Country("Canada");
        Country mexico = new Country("Mexico");

        world.addContinent(northAmerica);

        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);
        northAmerica.addCountry(mexico);
        //When
        BigDecimal totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal expectedPeople = new BigDecimal("3000003");
        assertEquals(expectedPeople,totalPeople);

    }
}
