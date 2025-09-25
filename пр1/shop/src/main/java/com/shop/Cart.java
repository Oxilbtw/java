package com.shop;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " додано в кошик.");
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            System.out.println(product.getName() + " видалено з кошика.");
        } else {
            System.out.println("Товар не знайдено в кошику.");
        }
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void clear() {
        products.clear();
    }

    @Override
    public String toString() {
        if (products.isEmpty())
            return "Кошик порожнiй.";
        StringBuilder sb = new StringBuilder("Ваш кошик:\n");
        for (Product p : products)
            sb.append(p).append("\n");
        sb.append("Загальна вартiсть: ").append(getTotalPrice());
        return sb.toString();
    }
}
