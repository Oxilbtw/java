package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Expense> readExpenses(String filePath) {
        List<Expense> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String date = parts[0];
                double amount = Double.parseDouble(parts[1]);
                String category = parts[2];

                list.add(new Expense(date, amount, category));
            }

        } catch (Exception e) {
            System.out.println("Помилка читання CSV: " + e.getMessage());
        }

        return list;
    }
}
