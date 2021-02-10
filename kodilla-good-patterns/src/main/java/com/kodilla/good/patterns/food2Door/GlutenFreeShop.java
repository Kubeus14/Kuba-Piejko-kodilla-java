package com.kodilla.good.patterns.food2Door;

import java.util.*;

public class GlutenFreeShop implements Supplier{
    private Map<Commodity, Integer> productsList;
    private List<Consumer> blackList;

    public GlutenFreeShop() {
        productsList = createProductList();
        blackList = createBlackList();
    }

    private Map<Commodity, Integer> createProductList() {

        Map<Commodity, Integer> productsList = new HashMap<>();

        productsList.put(new DairyProduct("Cheese", "Gouda"), 0);
        productsList.put(new AcssToCook("Sauce", "Tatar Sauce"), 10);
        productsList.put(new AcssToCook("Sauce", "Mayonnaise"), 43);
        productsList.put(new DairyProduct("Milk", "Goat"), 21);

        return productsList;
    }

    private List<Consumer> createBlackList() {
        List<Consumer> blackList = new ArrayList<>();
        blackList.add(new Consumer("Jan Nowak"));
        return blackList;
    }

    @Override
    public boolean process(Consumer customer, Map<Commodity, Integer> productsOrders) {
        return (!blackList.contains(customer) && isProductsAvailable(productsOrders));
    }

    private boolean isProductsAvailable(Map<Commodity, Integer> productsOrders) {
        for (Map.Entry<Commodity, Integer> entry : productsOrders.entrySet()) {
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if (productQty.orElse(0) < entry.getValue()) {
                System.out.println("There is no product");
                return false;
            }
        }
        return true;
    }
}
