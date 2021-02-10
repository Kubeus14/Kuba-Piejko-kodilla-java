package com.kodilla.good.patterns.food2Door;

public class AcssToCook extends Commodity {
    private String kindOfAccessories;

    public AcssToCook(String kindOfProduct, String kindOfAccessories) {
        super(kindOfProduct);
        this.kindOfAccessories=kindOfAccessories;
    }
}
