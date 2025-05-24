package telran.book.controller;

import telran.book.Newspaper;
import telran.book.model.Book;
import telran.book.model.Magazine;
import telran.book.model.Publication;

public class BookAppl {
    public static void main(String[] args) {
        Publication[] library = new Publication[5];

        library[0] = new Book("1984", 2022, "George Orwell", 9786589008194L);
        library[1] = new Magazine("The New York Times Magazine", 2024, "November");
        library[2] = new Newspaper("The Washington Post", 2025, 3, 25);
        library[3] = new Book("To Kill a Mockingbird", 1960, "Harper Lee", 9780061120084L);
        library[4] = new Book("Brave New World", 1932, "", 9780060850524L);

        System.out.println("Print all publications:");
        print(library);
        System.out.println("Print all publications from year 2024:");
        print(library, 2024);
        System.out.println("Print all publications from 2000 to 2022:");
        print(library, 2000, 2022);
    }

    public static void print(Publication[] publications) {
        for (Publication item : publications) {
            item.display();
        }
    }

    public static void print(Publication[] publications, int fromYear) {
        for (Publication item : publications) {
            if (item.getYearOfPublication() >= fromYear) {
                item.display();
            }
        }
    }

    public static void print(Publication[] publications, int fromYear, int toYear) {
        for (Publication item : publications) {
            if (item.getYearOfPublication() >= fromYear && item.getYearOfPublication() <= toYear) {
                item.display();
            }
        }
    }
}