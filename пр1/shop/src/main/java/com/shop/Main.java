package com.shop;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Category electronics = new Category(1, "Електронiка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук", electronics));
        catalog.add(new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном", smartphones));
        catalog.add(new Product(3, "Навушники", 2499.00, "Бездротовi навушники", accessories));

        Cart cart = new Cart();
        OrderHistory history = new OrderHistory();

        while (true) {
            System.out.println("\n=== МАГАЗИН ===");
            System.out.println("1. Переглянути каталог");
            System.out.println("2. Додати товар у кошик");
            System.out.println("3. Видалити товар з кошика");
            System.out.println("4. Переглянути кошик");
            System.out.println("5. Оформити замовлення");
            System.out.println("6. Пошук товарiв");
            System.out.println("7. Iсторiя замовлень");
            System.out.println("0. Вихiд");
            System.out.print("Ваш вибiр: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Product p : catalog) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Введiть ID товару: ");
                    int addId = sc.nextInt();
                    sc.nextLine();
                    boolean added = false;
                    for (Product p : catalog) {
                        if (p.getId() == addId) {
                            cart.addProduct(p);
                            added = true;
                            break;
                        }
                    }
                    if (!added)
                        System.out.println("Товар з таким ID не знайдено.");
                    break;
                case 3:
                    System.out.print("Введiть ID товару для видалення: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();
                    boolean removed = false;
                    for (Product p : cart.getProducts()) {
                        if (p.getId() == removeId) {
                            cart.removeProduct(p);
                            removed = true;
                            break;
                        }
                    }
                    if (!removed)
                        System.out.println("Товар з таким ID не знайдено в кошику.");
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожнiй!");
                    } else {
                        Order order = new Order(cart);
                        history.addOrder(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 6:
                    sc.nextLine();
                    System.out.print("Введiть назву або категорiю: ");
                    String keyword = sc.nextLine();
                    boolean found = false;
                    for (Product p : catalog) {
                        if (p.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                                p.getCategory().getName().toLowerCase().contains(keyword.toLowerCase())) {
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Нiчого не знайдено.");
                    }
                    break;

                case 7:
                    history.showOrders();
                    break;
                case 0:
                    System.out.println("Дякуємо за покупки!");
                    sc.close();
                    return;
                default:
                    System.out.println("Невiрний вибiр!");
            }
        }
    }
}
