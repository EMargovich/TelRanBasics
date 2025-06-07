package telran.book.dao;

import telran.book.model.Book;

public class Library {
    Book[] books;
    int size; //Count of books in library

    public Library (int capacity) {
        books = new Book[capacity];
    }

    public boolean addBook(Book book) {
        if(books.length == size) {
            return false;
        }
        books[size] = book;
        size++;
        return true;
    }

    public Book findBookTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book removeBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                Book victim = books[i];
                books[i] = books[size-1];
                books[size-1] = null;
                size--;
                return victim;
            }
        }
        return null;
    }

    public Book updateBook(String author, String newAuthor) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(newAuthor)) {
                return books[i];
            }
        }
        return null;
    }

    public void printBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public int getSize() {
        return size;
    }

    // Реализуйте метод printBooks(int fromYear), который выводит книги, изданные с указанного года.
    public void printBooks(int fromYear) {
        for (int i = 0; i < size; i++) {
            if (books[i].getYearOfPublishing() >= fromYear) {
                System.out.println(books[i]);
            }
        }
    }

    // Реализуйте метод printBooks(int fromYear, int toYear), который выводит книги в заданном диапазоне лет.
    public void printBooks(int fromYear, int toYear) {
        for (int i = 0; i < size; i++) {
            if (books[i].getYearOfPublishing() >= fromYear &&
                    books[i].getYearOfPublishing() <= toYear ) {
                System.out.println(books[i]);
            }
        }
    }

    // Реализуйте метод findIndexOfBookByTitle(String title) — он возвращает индекс книги по названию или -1, если не найдено.
    public int findIndexOfBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if ( title.equals(books[i].getTitle()) ) {
                return i;
            }
        }
        return  -1;
    }
}