package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal clcCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15),clcCost);
    }
    @Test
    public void testBasicPizzaOrderDescription(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String pizzaDescription = pizzaOrder.getDescription();
        //Then
        assertEquals("Order pizza with: ",pizzaDescription);
    }
    @Test
    public void testSimplePizzaCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SimplePizza(pizzaOrder);
        //When
        BigDecimal clcCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(30),clcCost);
    }
    @Test
    public void testSimplePizzaCostDescription(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SimplePizza(pizzaOrder);
        //When
        String descriptionPizza = pizzaOrder.getDescription();
        //Then
        assertEquals("Order pizza with: dough, tomato sauce, cheese ",descriptionPizza);
    }
    @Test
    public void testPizzaWithThreeIngredientsCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SimplePizza(pizzaOrder);
        pizzaOrder = new ThreeAdditionalIngredients(pizzaOrder);
        //When
        BigDecimal costPizza = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(45),costPizza);
    }
    @Test
    public void testPizzaWithThreeIngredientsDescription(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SimplePizza(pizzaOrder);
        pizzaOrder = new ThreeAdditionalIngredients(pizzaOrder);
        //When
        String dscPizza = pizzaOrder.getDescription();
        //Then
        assertEquals("Order pizza with: dough, tomato sauce, cheese  ,ham, pineapple, mushrooms",dscPizza);
    }
    @Test
    public void testExtraPizzaCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SimplePizza(pizzaOrder);
        pizzaOrder = new FiveAdditionalIngredients(pizzaOrder);
        pizzaOrder = new ThickCrustPizza(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(55),cost);
    }
    @Test
    public void testExtraPizzaDescription(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SimplePizza(pizzaOrder);
        pizzaOrder = new FiveAdditionalIngredients(pizzaOrder);
        pizzaOrder = new ThickCrustPizza(pizzaOrder);
        //When
        String dsc = pizzaOrder.getDescription();
        //Then
        assertEquals("Order pizza with: dough, tomato sauce, cheese ,olives, salami, onion, jalapeno, prawns ,thick crust",dsc);
    }
}
