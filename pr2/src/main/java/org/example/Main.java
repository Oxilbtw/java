package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Oxil\\Desktop\\pr2.csv";

        List<Expense> expenses = CsvReader.readExpenses(filePath);
        ExpenseService service = new ExpenseService(expenses);

        System.out.println("=== Загальний баланс ===");
        System.out.println(service.getTotalBalance());

        System.out.println("\n=== Транзакцій за 01-2024 ===");
        System.out.println(service.countByMonth("01-2024"));

        System.out.println("\n=== ТОП-10 витрат ===");
        service.getTop10Expenses().forEach(System.out::println);

        System.out.println("\n=== Найбільша витрата ===");
        System.out.println(service.getMaxExpense());

        System.out.println("\n=== Найменша витрата ===");
        System.out.println(service.getMinExpense());

        System.out.println("\n=== Витрати по категоріях ===");
        for (Map.Entry<String, Double> entry : service.sumByCategory().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n=== Витрати по місяцях ===");
        for (Map.Entry<String, Double> entry : service.sumByMonth().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
