package com.kodilla.patterns.builders.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigMac(){
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .ingredient("Cheese")
                .ingredient("Onion")
                .bun("Graham")
                .ingredient("Salad")
                .sauce("BBQ")
                .burgers(2)
                .build();
        System.out.println(bigMac);
        //When
        int burgerContains = bigMac.getIngredients().size();
        int burgerQuantity = bigMac.getBurgers();
        String bunKind = bigMac.getBun();
        String sauceKind = bigMac.getSauce();
        //Then
        assertEquals(3,burgerContains);
        assertEquals(2,burgerQuantity);
        assertEquals("Graham",bunKind);
        assertEquals("BBQ",sauceKind);

    }
}
