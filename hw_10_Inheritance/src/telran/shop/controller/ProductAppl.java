package telran.shop.controller;

import telran.shop.model.*;

public class ProductAppl {

    public static void main(String[] args) {
        Product[] products = createArr();

        printPriceTotal(products);

        printPriceKosher(products);

        printPriceNotFood(products);
    }

    private static void printPriceNotFood(Product[] products) {
        System.out.println("\nPrice list (only not food)");
        for (Product product : products) {
            if(!(product instanceof Food)) {
                System.out.printf("\"%-40s NIS %-10.2f\n",product.getName(), product.getPrice() );
            }
        }
    }

    private static void printPriceKosher(Product[] products) {
        System.out.println("\nPrice list (only kosher food)");
        for (Product product : products) {
            if(product instanceof Food && ((Food) product).isKosher()) {
                System.out.printf("\"%-40s NIS %-10.2f %-5s%n",
                        product.getName(),
                        product.getPrice(),
                        "Kosher");
            }
        }
    }

    private static void printPriceTotal(Product[] products) {
        System.out.println("\nPrice list");
        for (Product product : products) {
            System.out.printf("%-40s NIS %-30.2f%n",product.getName(), product.getPrice() );
        }

    }

    protected static Product[] createArr() {

        Product[] products = new Product[12];

        products[0] = new Product(100100100100L, "Toothpaste Colgate", 2.49);
        products[1] = new Product(200200200200L, "Dishwashing Liquid Fairy", 3.99);
        products[2] = new Product(300300300300L, "Pack of Toilet Paper (12 rolls)", 6.75);

        products[3] = new Food(444444444444L, "White Bread", 2.50, true, "2025-06-05");
        products[4] = new Food(555555555555L, "Apple", 0.80, true, "2025-06-01");
        products[5] = new Food(666666666666L, "Bottled Water 1.5L", 1.20, false, "2026-01-01");

        products[6] = new Dairy(777777777777L, "Plain Yogurt 500g", 2.30, true, "2025-06-08", "Cow", 3.5);
        products[7] = new Dairy(888888888888L, "Goat Cheese 200g", 5.90, true, "2025-06-15", "Goat", 28.0);
        products[8] = new Dairy(999999999999L, "Milk 1L", 1.99, true, "2025-06-05", "Cow", 1.5);

        products[9]  = new Meat(111222333444L, "Beef Steak 500g", 9.99, true, "2025-06-03", "Beef");
        products[10] = new Meat(222333444555L, "Chicken Thighs 1kg", 6.50, true, "2025-05-31", "Chicken");
        products[11] = new Meat(333444555666L, "Pork Chops 700g", 7.20, false, "2025-06-07", "Pork");

        return products;
    }


}
