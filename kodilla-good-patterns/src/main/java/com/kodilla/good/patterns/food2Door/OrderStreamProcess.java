package com.kodilla.good.patterns.food2Door;

import java.util.List;

public class OrderStreamProcess {

        public void allOrders(List<OrderRequest> orderRequest) {

            orderRequest.stream()
                    .map(n -> {
                        System.out.println("Your order is under process " + n.getConsumer().getName());
                        return n.getSupplier().process(n.getConsumer(), n.getProductOrderRequest());
                    })
                    .forEach(t -> System.out.println("Order is completed: " + t + "\n"));
        }

}
