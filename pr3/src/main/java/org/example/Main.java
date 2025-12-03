package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        try {
            System.out.print("Введіть перше число: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введіть друге число: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введіть операцію (+, -, *, /, sqrt): ");
            String op = scanner.nextLine();

            double result;

            switch (op) {
                case "+":
                    result = calc.add(num1, num2);
                    System.out.println("Результат: " + result);
                    break;
                case "-":
                    result = calc.subtract(num1, num2);
                    System.out.println("Результат: " + result);
                    break;
                case "*":
                    result = calc.multiply(num1, num2);
                    System.out.println("Результат: " + result);
                    break;
                case "/":
                    result = calc.divide(num1, num2);
                    System.out.println("Результат: " + result);
                    break;
                case "sqrt":
                    result = calc.sqrt(num1);
                    System.out.println("Квадратний корінь: " + result);
                    break;
                default:
                    System.out.println("Невідомо");
            }

        } catch (NumberFormatException e) {
            System.out.println("Помилка: введіть коректне число");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Обробка завершена");
            scanner.close();
        }
    }
}
