package com.example.order.storage;

import com.example.order.processing.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderStorage<T extends Product> {

    private final List<T> orders = new ArrayList<>();

    public synchronized void addOrder(T order) {
        orders.add(order);
        System.out.println("Order added: " + order.getName());
    }

    public synchronized List<T> getOrders() {
        return Collections.unmodifiableList(new ArrayList<>(orders));
    }
}
