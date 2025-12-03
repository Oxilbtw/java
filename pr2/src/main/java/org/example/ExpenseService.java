package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ExpenseService {

    private final List<Expense> expenses;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ExpenseService(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public double getTotalBalance() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public int countByMonth(String monthYear) {
        return (int) expenses.stream()
                .filter(e -> LocalDate.parse(e.getDate(), formatter)
                        .format(DateTimeFormatter.ofPattern("MM-yyyy"))
                        .equals(monthYear))
                .count();
    }

    public List<Expense> getTop10Expenses() {
        return expenses.stream()
                .filter(e -> e.getAmount() < 0)
                .sorted(Comparator.comparing(Expense::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public Expense getMaxExpense() {
        return expenses.stream()
                .filter(e -> e.getAmount() < 0)
                .min(Comparator.comparing(Expense::getAmount))
                .orElse(null);
    }

    public Expense getMinExpense() {
        return expenses.stream()
                .filter(e -> e.getAmount() < 0)
                .max(Comparator.comparing(Expense::getAmount))
                .orElse(null);
    }

    public Map<String, Double> sumByCategory() {
        return expenses.stream()
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }

    public Map<String, Double> sumByMonth() {
        return expenses.stream()
                .collect(Collectors.groupingBy(
                        e -> LocalDate.parse(e.getDate(), formatter)
                                .format(DateTimeFormatter.ofPattern("MM-yyyy")),
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }
}
