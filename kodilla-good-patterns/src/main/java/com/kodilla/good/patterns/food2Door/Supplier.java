package com.kodilla.good.patterns.food2Door;

import java.util.Map;

public interface Supplier {
    boolean process(Consumer consumer, Map<Commodity,Integer> productOrder);
}
