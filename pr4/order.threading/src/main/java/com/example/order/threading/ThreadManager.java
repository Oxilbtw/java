package com.example.order.threading;

import com.example.order.processing.OrderProcessor;
import com.example.order.processing.Product;

public class ThreadManager<T extends Product> {

    private final OrderProcessor<T> processor;

    public ThreadManager(OrderProcessor<T> processor) {
        this.processor = processor;
    }

    public void processInThreads() {
        Runnable task = () -> {
            System.out.println("[Thread] Starting processing in thread: " + Thread.currentThread().getName());
            processor.processOrders();
            System.out.println("[Thread] Finished processing in thread: " + Thread.currentThread().getName());
        };
        Thread t = new Thread(task, "OrderProcessor-1");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
