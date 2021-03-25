package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite{
    @Test
    void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent europa = new Continent("Europa");

        Country italy = new Country("Italy");
        Country germany = new Country("Germany");
        Country spain = new Country("Spain");

        world.addContinent(europa);

        europa.addCountry(italy);
        europa.addCountry(germany);
        europa.addCountry(spain);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal totalExpectedPeople = new BigDecimal("3000003");
        assertEquals(totalExpectedPeople,totalPeople);
    }
}
