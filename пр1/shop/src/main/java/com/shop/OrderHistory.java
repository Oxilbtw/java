package com.shop;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("Iсторiя замовлень порожня.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
                System.out.println("--------------");
            }
        }
    }
}
