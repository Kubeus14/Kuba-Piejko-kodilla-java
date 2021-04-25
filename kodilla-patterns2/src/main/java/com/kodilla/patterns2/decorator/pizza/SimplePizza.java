package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SimplePizza extends AbstractPizzaOrderDecorator{
    public SimplePizza(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(15));
    }
    @Override
    public String getDescription(){
        return super.getDescription()+"dough, tomato sauce, cheese ";
    }
}
