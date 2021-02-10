package com.kodilla.good.patterns.food2Door;

import java.util.Map;

public class OrderRequest {
    private Consumer consumer;
    private Supplier supplier;
    private Map<Commodity, Integer> productOrderRequest;


    public OrderRequest(Consumer consumer, Supplier supplier, Map<Commodity, Integer> productOrderRequest) {
        this.consumer = consumer;
        this.supplier = supplier;
        this.productOrderRequest = productOrderRequest;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Map<Commodity, Integer> getProductOrderRequest() {
        return productOrderRequest;
    }
}
