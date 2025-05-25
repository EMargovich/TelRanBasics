package telran.computer.controller;

import telran.computer.model.Computer;
import telran.computer.model.Laptop;
import telran.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        Computer comp = new Computer("i5", 12, 1024, "Asus");
        Laptop laptop = new Laptop("i7", 16, 1024, "Acer", 4, 2.3);

        Computer[] shop = new Computer[3];
        shop[0] = comp;
        shop[1] = laptop;
        shop[2] = new Smartphone("Dragon", 8 , 256, "Poco", 0.1, 18, 1234567890L);
 //       showBrands(shop);

        Smartphone sm2 = (Smartphone) shop[2];
//        System.out.println(sm2.getImei());

//        shop[2].display();
//        sm2.display();
//
//        if (shop[2] instanceof Smartphone) {
//            shop[2].display();
//        }

        showComputers(shop);
    }

    private static void showComputers(Computer[] shop) {
        for(Computer computer : shop) {
            computer.display();
        }
    }

    private static void showBrands(Computer[] shop) {
        for (int i = 0; i < shop.length; i++) {
            System.out.println(shop[i].getBrand());
        }
    }
}

//ДЗ Вывести данные о молочных продуктах, данные о мясных продуктов,
//цены для кошерных продуктов, информацию о не еде