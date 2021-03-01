package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
    //Given
        World world = new World();
        Continent europa = new Continent("Europa");
        Country italy = new Country("Italy");
        Country hungary = new Country("Hungary");
        Country france = new Country("France");

        world.addContinent(europa);

        europa.addCountry(italy);
        europa.addCountry(hungary);
        europa.addCountry(france);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal expectedPeople = new BigDecimal("300003");
        assertEquals(expectedPeople,totalPeople);
    }
}
