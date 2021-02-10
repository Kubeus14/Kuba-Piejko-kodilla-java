package com.kodilla.good.patterns.food2Door;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HealthyShop implements Supplier{
    private Map<Commodity, Integer> listOfProducts;

    public HealthyShop() {
        listOfProducts = makeListOfProducts();
    }

    private Map<Commodity, Integer> makeListOfProducts() {

        Map<Commodity, Integer> li = new HashMap<>();

        listOfProducts.put(new DairyProduct("Milk", "Cow"), 23);
        listOfProducts.put(new DairyProduct("Cheese", "Gouda"), 0);
        listOfProducts.put(new AcssToCook("Sauce", "Ketchup"), 17);
        listOfProducts.put(new AcssToCook("Spice", "Chili"), 5);

        return listOfProducts;
    }

    @Override
    public boolean process(Consumer consumer, Map<Commodity, Integer> productsOrders) {
        return (productsOrders.size() >= 2 && isProductsAvailable(productsOrders));
    }

    private boolean isProductsAvailable(Map<Commodity, Integer> productsOrders) {
        for (Map.Entry<Commodity, Integer> entry : productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(listOfProducts.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("Sorry we don't have this product");
                return false;
            }
        }
        return true;
    }
}
