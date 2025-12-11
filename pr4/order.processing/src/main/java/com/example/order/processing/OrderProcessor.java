package com.example.order.processing;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class OrderProcessor<T extends Product> {

    private final List<T> orders;

    public OrderProcessor(List<T> orders) {
        this.orders = orders;
    }

    public void processOrders() {
        orders.forEach(this::processOrder);
    }

    public void processOrder(T order) {
        try {
            Objects.requireNonNull(order, "Order cannot be null");
            System.out.println("Processing order: " + order.getName() + " - $" + order.getPrice());
        } catch (Exception e) {
            throw new GenericProcessingException("Failed to process order: " + e.getMessage(), e);
        }
    }

    public List<T> filterByName(String substring) {
        return orders.stream()
                     .filter(o -> o.getName().toLowerCase().contains(substring.toLowerCase()))
                     .collect(Collectors.toList());
    }
}
