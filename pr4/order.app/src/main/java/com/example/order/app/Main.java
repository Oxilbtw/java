package com.example.order.app;

import com.example.order.processing.*;
import com.example.order.storage.OrderStorage;
import com.example.order.threading.ThreadManager;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Electronics e1 = Electronics.builder()
                .name("Electronics " + random.nextInt(100))
                .price(50 + random.nextDouble() * 950)
                .brand("Brand " + random.nextInt(50))
                .build();

        Clothing c1 = Clothing.builder()
                .name("Clothing " + random.nextInt(100))
                .price(10 + random.nextDouble() * 290) 
                .size("M")
                .build();

        OrderStorage<Product> storage = new OrderStorage<>();
        storage.addOrder(e1);
        storage.addOrder(c1);

        OrderProcessor<Product> processor = new OrderProcessor<>(storage.getOrders());
        ThreadManager<Product> manager = new ThreadManager<>(processor);
        manager.processInThreads();

        List<Product> filtered = processor.filterByName("pro");
        System.out.println("Filtered size: " + filtered.size());
    }
}
