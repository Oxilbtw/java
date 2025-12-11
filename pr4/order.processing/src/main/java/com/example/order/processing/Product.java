package com.example.order.processing;

import lombok.Getter;

@Getter
public abstract class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
