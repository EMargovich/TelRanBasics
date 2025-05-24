package telran.book.model;

public class Book extends Publication {
    private long isbn;

    public Book(String title) {
        super(title);
    }

    public Book(String title, int yearOfPublication, String author, long isbn) {
        super(title, yearOfPublication, author);
        setIsbn(isbn);
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        String isbnStr = String.valueOf(isbn);

        if (isbnStr.length() == 13 || isbnStr.length() == 9) {
            this.isbn = isbn;
        } else {
            System.out.println("Invalid ISBN entered.");
        }
    }

    public void display() {
        super.display();
        System.out.println("ISBN: " + isbn + "\n");
    }

    }