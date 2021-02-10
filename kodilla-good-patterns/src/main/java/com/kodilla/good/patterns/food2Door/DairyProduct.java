package com.kodilla.good.patterns.food2Door;

public class DairyProduct extends Commodity {
    private String kindOfDairy;

    public DairyProduct(String kindOfProduct, String kindOfDairy) {
        super(kindOfProduct);
        this.kindOfDairy = kindOfDairy;
    }
}
