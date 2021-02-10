package com.kodilla.good.patterns.food2Door;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ExtraFoodShop implements Supplier{
    private Map<Commodity, Integer> listOfProducts;
    private Map<Commodity, Integer> makeListOfProducts() {
        Map<Commodity, Integer> listOfProducts = new HashMap<>();
        listOfProducts.put(new DairyProduct("Milk", "Cow"), 0);
        listOfProducts.put(new DairyProduct("Yoghurt", "AppleYoghurt"), 11);
        listOfProducts.put(new AcssToCook("Sose", "BBQ"), 7);
        listOfProducts.put(new AcssToCook("Spice", "oregano"), 8);

        return listOfProducts;
    }
    public ExtraFoodShop() {
        listOfProducts = makeListOfProducts();
    }
    public boolean process(Consumer consumer, Map<Commodity,Integer> productOrder){
        for (Map.Entry<Commodity, Integer> entry : productOrder.entrySet()){
            Optional<Integer> productQty = Optional.ofNullable(listOfProducts.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("We don't have this product now");
                return false;
            }
        }
        return true;
    }
}
