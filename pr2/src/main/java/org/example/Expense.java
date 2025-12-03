package org.example;

public class Expense {

    private String date;
    private double amount;
    private String category;

    public Expense(String date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return date + " | " + amount + " | " + category;
    }
}
