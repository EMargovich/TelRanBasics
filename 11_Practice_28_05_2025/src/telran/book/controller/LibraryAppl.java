package telran.book.controller;

import telran.book.dao.Library;
import telran.book.model.Book;

public class LibraryAppl {
    public static void main(String[] args) {
        Library lib = new Library(12);

        Book book1 = new Book(9780451524935L, "1984", "Orwell", 1949);
        Book book2 = new Book(9780061120084L, "To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book(9780743273565L, "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book4 = new Book(9780590353427L, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997);
        Book book5 = new Book(9780547928227L, "The Hobbit", "J.R.R. Tolkien", 1937);
        Book book6 = new Book(9780060850524L, "Brave New World", "Aldous Huxley", 1932);
        Book book7 = new Book(9780316769488L, "The Catcher in the Rye", "J.D. Salinger", 1951);
        Book book8 = new Book(9781503290563L, "Pride and Prejudice", "Jane Austen", 1813);
        Book book9 = new Book(9780544003415L, "The Lord of the Rings", "J.R.R. Tolkien", 1954);

        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);
        lib.addBook(book5);
        lib.addBook(book6);
        lib.addBook(book7);
        lib.addBook(book8);
        lib.addBook(book9);

//        System.out.println("Size of library:" + lib.getSize());
//
//        System.out.println(lib.removeBookByTitle("1984"));
//
//        lib.printBooks();
//        System.out.println("Size of library:" + lib.getSize());

        //Реализуйте метод printBooks(), который выводит все книги в библиотеке.
        System.out.println("\n===================== \nAll books:  ");
        lib.printBooks();

        //Реализуйте метод printBooks(int fromYear), который выводит книги, изданные с указанного года.
        int fromYear = 1950;
        System.out.println("\n===================== \nThe books from year " + fromYear + ": ");
        lib.printBooks(fromYear);

        // Реализуйте метод printBooks(int fromYear, int toYear), который выводит книги в заданном диапазоне лет.
        int toYear = 1955;
        System.out.println("\n===================== \nThe books from year " + fromYear + " to year " + toYear + ": ");
        lib.printBooks(fromYear, toYear);


        // Реализуйте метод findIndexOfBookByTitle(String title) — он возвращает индекс книги по названию или -1, если не найдено.
        System.out.println("\n============================\nFind index of books: ");
        System.out.println("Index of book \"The Hobbit\" " + lib.findIndexOfBookByTitle("The Hobbit"));
        System.out.println("Index of book \"To Kill a Mockingbird\" " + lib.findIndexOfBookByTitle("To Kill a Mockingbird"));
        System.out.println("Index of book \"To Kill a Mockingbird Again\" " + lib.findIndexOfBookByTitle("To Kill a Mockingbird Again"));
    }
}
