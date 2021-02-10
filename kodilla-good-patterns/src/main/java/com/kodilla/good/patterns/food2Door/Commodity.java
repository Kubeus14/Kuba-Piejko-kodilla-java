package com.kodilla.good.patterns.food2Door;

abstract public class Commodity {
    private String kindOfProduct;

    public Commodity(String kindOfProduct) {
        this.kindOfProduct = kindOfProduct;
    }
    @Override
    public String toString() {
        return "Kind of product='" + kindOfProduct + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commodity commodity = (Commodity) o;

        return kindOfProduct.equals(commodity.kindOfProduct);
    }

    @Override
    public int hashCode() {
        return kindOfProduct.hashCode();
    }
}
