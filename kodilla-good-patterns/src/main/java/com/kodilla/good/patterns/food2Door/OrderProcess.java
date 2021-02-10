package com.kodilla.good.patterns.food2Door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProcess {
    public List<OrderRequest> retrieve() {
        List<OrderRequest> orderRequestList = new ArrayList<>();

        Consumer customer = new Consumer("Jan Nowak");
        Supplier supplier = new ExtraFoodShop();
        Map<Commodity, Integer> productsList = new HashMap<>();
        productsList.put(new AcssToCook("Sauce", "BBQ"), 1);
        productsList.put(new DairyProduct("Milk", "Cow"), 2);
        productsList.put(new AcssToCook("Spice", "oregano"), 3);

        orderRequestList.add(new OrderRequest(customer, supplier, productsList));

        Consumer customer1 = new Consumer("Piotr Wolak");
        Supplier foodProducer1 = new GlutenFreeShop();
        Map<Commodity, Integer> productsList1 = new HashMap<>();
        productsList.put(new DairyProduct("Yoghurt", "AppleYoghurt"), 2);
        productsList.put(new DairyProduct("Milk", "Cow"), 3);
        productsList.put(new AcssToCook("Sauce", "BBQ"), 17);

        orderRequestList.add(new OrderRequest(customer1, foodProducer1, productsList1));

        return orderRequestList;
    }
}
